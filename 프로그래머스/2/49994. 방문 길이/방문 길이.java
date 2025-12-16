import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1}; // U, D, R, L
    static int[] dy = {1, -1, 0, 0}; // U, D, R, L

    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] visited = new boolean[11][11][4];
        
        int x = 5, y = 5;
        for (char dir : dirs.toCharArray()) {
            int d = -1;
            if (dir == 'U') d = 0;
            if (dir == 'D') d = 1;
            if (dir == 'R') d = 2;
            if (dir == 'L') d = 3;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx < 0 || ny < 0 || nx > 10 || ny > 10) continue;
            
            int opposite = (d % 2 == 0) ? d + 1 : d - 1;
            
            if (!visited[x][y][d]) {
                visited[x][y][d] = true;
                visited[nx][ny][opposite] = true;
                answer++;
            }
            
            x = nx;
            y = ny;
        }
        
        return answer;
    }
}