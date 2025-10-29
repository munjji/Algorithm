import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        
        for (int[] e: edge) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        
        dist[1] = 0;
        q.offer(1);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
        
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (max == dist[i]) answer++;
        }
        
        return answer;
    }
}