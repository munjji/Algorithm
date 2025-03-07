import java.util.*;

class Solution {
    public int solution(int[] scovilles, int K) {
        int answer = 0;
        PriorityQueue<Integer> sc = new PriorityQueue<>();
        
        for (int scoville: scovilles) {
            sc.offer(scoville);
        }
        
        while (sc.size() >= 2 && sc.peek() < K) {            
                int first = sc.poll();
                int second = sc.poll();
        
                int new_scoville = first + (second * 2);

                sc.offer(new_scoville);
                answer++;
        }
    
        
        return (sc.peek() >= K) ? answer: -1;
    }
}