import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        // 균일하게 만들기 위해 항상 가장 큰 값을 줄인다
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.offer(work);
        }
        
        while (n > 0) {
            int max = pq.poll();
            
            if (max == 0) break;
            n--;
            max--;
            pq.offer(max);
        }
        
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            answer += cur * cur;
        }
        
        return answer;
    }
}