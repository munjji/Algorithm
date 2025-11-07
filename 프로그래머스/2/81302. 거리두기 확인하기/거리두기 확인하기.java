import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        char[][] maps = new char[5][5];
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                maps[j] = places[i][j].toCharArray();
            }
            
            if (check(maps)) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }
    
    static boolean check(char[][] maps) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (maps[i][j] == 'P') {
                    if (!bfs(i, j, maps)) return false;
                }
            }
        }
        
        return true;
    }
    
    static boolean bfs(int i, int j, char[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j, 0});
        boolean[][] visited = new boolean[5][5];
        visited[i][j] = true;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                int dist = cur[2];
                
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if (visited[nx][ny]) continue;
                if (maps[nx][ny] == 'P' && dist < 2) return false;
                if (dist == 2) continue;
                if (maps[nx][ny] == 'O' && !visited[nx][ny] && dist < 1) {
                    q.offer(new int[]{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return true;
    }
}