import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[1000000*3];

        q.offer(new int[]{x, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int nx = cur[0];
            int cnt = cur[1];
            
            if (nx == y) {
                return cnt;
            }
            
            if (!visited[nx + n] && nx + n <= y) {
                q.offer(new int[]{nx + n, cnt + 1});
                visited[nx + n] = true;
            }
            
            if (!visited[nx * 2] && nx * 2 <= y) {
                q.offer(new int[]{nx * 2, cnt + 1});
                visited[nx * 2] = true;
            } 
            
            if (!visited[nx * 3] && nx * 3 <= y) {
                q.offer(new int[]{nx * 3, cnt + 1});
                visited[nx * 3] = true;
            } 
        }
        
        return -1;
    }
}