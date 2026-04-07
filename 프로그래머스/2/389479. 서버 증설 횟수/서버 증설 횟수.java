import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int n = players.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 서버 1대 만료 시각
        
        for (int t = 0; t < n; t++) {
            while (!pq.isEmpty() && pq.peek() <= t) {
                pq.poll();
            }
            
            int need = players[t] / m;
            int active = pq.size();
            
            int add = need - active;
            if (add > 0) {
                answer += add;
                for (int i = 0; i < add; i++) {
                    pq.offer(t + k);
                }
            }
        }
        
        return answer;
    }
}