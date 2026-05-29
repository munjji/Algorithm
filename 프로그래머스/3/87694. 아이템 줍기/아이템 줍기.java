import java.util.*;

class Solution {
    
    static int[][] board = new int[102][102];
    static boolean[][] visited = new boolean[102][102];
    static int itemX, itemY;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        this.itemX = itemX * 2;
        this.itemY = itemY * 2;
        
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    board[y][x] = 1;
                }
            }
        }
        
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for (int y = y1 + 1; y < y2; y++) {
                for (int x = x1 + 1; x < x2; x++) {
                    board[y][x] = 0;
                }
            }
        }
        
        int answer = bfs(characterY * 2, characterX * 2);
        
        return answer;
    }
    
    static private int bfs(int y, int x) {
        visited[y][x] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            int cy = cur[0];
            int cx = cur[1];
            int cnt = cur[2];
            
            if (cy == itemY && cx == itemX) {
                return cnt / 2;
            }
            
            for (int d = 0; d < 4; d++) {
                int sy = cy + dy[d];
                int sx = cx + dx[d];
                
                if (sy < 0 || sx < 0 || sy >= 102 || sx >= 102) continue;
                if (visited[sy][sx]) continue;
                if (board[sy][sx] == 0) continue;
                
                visited[sy][sx] = true;
                q.offer(new int[]{sy, sx, cnt + 1});
            }
        }
        
        return -1;
    }
}