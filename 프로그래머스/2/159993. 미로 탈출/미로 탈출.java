import java.util.*;

class Solution {
    static int n, m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;
        
    public int solution(String[] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length();
        
        map = new char[n][m];
        
        int sx = -1, sy = -1;
        int lx = -1, ly = -1;
        
        for (int i = 0; i < n; i++) {
            String line = maps[i];
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') { sx = i; sy = j; }
                else if (map[i][j] == 'L') { lx = i; ly = j; }
            }
        }
        
        int sToL = bfs(sx, sy, 'L');
        if (sToL == -1) return -1;
        int lToE = bfs(lx, ly, 'E');
        if (lToE == -1) return -1;
        
        return sToL + lToE;
    }
    
    static int bfs(int sx, int sy, char target) {
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], -1);
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        dist[sx][sy] = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            
            if (map[x][y] == target) return dist[x][y];
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] == 'X') continue;
                if (dist[nx][ny] != -1) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        
        return -1;
    }
}