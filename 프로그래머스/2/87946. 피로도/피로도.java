import java.util.*;

class Solution {
    int answer = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        int number = dungeons.length;
        visited = new boolean[number];
        
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    private void dfs (int current, int[][] dungeons, int count) {
        answer = Math.max(answer, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            int need = dungeons[i][0];
            int minus = dungeons[i][1];
            
            if (visited[i]) continue;
            if (current < need) continue;
            
            visited[i] = true;
            dfs(current - minus, dungeons, count + 1);
            visited[i] = false;
        }
    }
}