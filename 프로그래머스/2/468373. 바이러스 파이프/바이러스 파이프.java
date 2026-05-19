import java.util.*;

class Solution {
    
    static class Edge {
        int to, type;
        
        Edge (int to, int type) {
            this.to = to;
            this.type = type;
        }
    }
    
    static List<Edge>[] graph;
    static int answer = 0;
    static int k;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        
        this.k = k;
        graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int type = e[2];
            
            graph[u].add(new Edge(v, type));
            graph[v].add(new Edge(u, type));
        }
        
        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;
        
        dfs(0, infected);
        
        return answer;
    }
    
    static void dfs(int depth, boolean[] infected) {
        answer = Math.max(answer, count(infected));
        
        if (depth == k) return;
        
        for (int type = 1; type <= 3; type++) {
            boolean[] next = spread(type, infected);
            dfs(depth + 1, next);
        }
    }
    
    static boolean[] spread(int type, boolean[] infected) {
        boolean[] next = infected.clone();
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 1; i < next.length; i++) {
            if (next[i]) q.offer(i);
        }
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Edge edge : graph[cur]) {
                if (edge.type != type) continue;
                if (next[edge.to]) continue;
                
                q.offer(edge.to);
                next[edge.to] = true;
            }
        }
        
        return next;
    }
    
    static int count(boolean[] infected) {
        int cnt = 0;
        for (boolean b : infected) {
            if (b) cnt++;
        }

        return cnt;
    }
}