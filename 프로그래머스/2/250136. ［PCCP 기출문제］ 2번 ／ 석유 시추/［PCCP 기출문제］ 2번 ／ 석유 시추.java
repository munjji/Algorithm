import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        boolean[][] visited = new boolean[n][m];
        int[] oilSum = new int[m];
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    
                    int oil = 0;
                    Set<Integer> colSet = new HashSet<>();
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0];
                        int y = cur[1];
                        oil++;
                        colSet.add(y);
                        
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            
                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                            if (visited[nx][ny] || land[nx][ny] == 0) continue;
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                    
                    for (int col : colSet) {
                        oilSum[col] += oil;
                    }
                }
            }
        }
        
        Arrays.sort(oilSum);
        
        return oilSum[oilSum.length - 1];
    }
}