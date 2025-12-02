import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int w = r[2];
            graph[a].add(new int[]{b, w});
            graph[b].add(new int[]{a, w});
        }
        
        int[] dist = new int[N + 1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o1[1], o2[1])
        );
        pq.offer(new int[]{1, 0});
    
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];
            
            if (cost > dist[now]) continue;
            
            for (int[] next : graph[now]) {
                int nextNode = next[0];
                int nextCost =  cost + next[1];
                
                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new int[]{nextNode, nextCost});
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }

        return answer;
    }
}