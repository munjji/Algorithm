import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int network = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, i);
                network++;
            }
        } 
        return network;
    }
    
    public void dfs(int[][] computers, int node) {
        visited[node] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[node][i] == 1) {
                dfs(computers, i);
            }
        }
    }
}