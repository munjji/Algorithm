import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            int u = e[0];
            int v = e[1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph[cur]) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
        
        int max = Arrays.stream(dist).max().orElse(-1);
        
        int answer = 0;
        for (int d : dist) {
            if (d == max) answer++;
        }
        
        return answer;
    }
}