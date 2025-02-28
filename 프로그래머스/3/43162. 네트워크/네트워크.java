import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int network = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                network++;
            }
        } 
        return network;
    }
    
    public void dfs(int[][] computers, boolean[] visited, int node) {
        visited[node] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[node][i] == 1) {
                dfs(computers, visited, i);
            }
        }
    }
}