import java.util.*;

class Solution {
    
    static int n, m;
    static boolean[][] visited;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        int answer = bfs(maps, 0, 0);
        return answer;
    }
    
    static private int bfs (int[][] maps, int i, int j) {
        visited[i][j] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j, 1});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cnt = cur[2];
            
            if (cx == n - 1 && cy == m - 1) {
                return cnt;
            }
            
            for (int d = 0; d < 4; d++) {
                int sx = cx + dx[d];
                int sy = cy + dy[d];
                
                if (sx < 0 || sy < 0 || sx >= n || sy >= m) continue;
                if (visited[sx][sy]) continue;
                if (maps[sx][sy] == 0) continue;
                
                visited[sx][sy] = true;
                q.offer(new int[]{sx, sy, cnt + 1});
            }
        }
        
        return -1;
    }
}