import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int index = 0;
        int cur_weight = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < bridge_length; i++) {
            q.add(0);
        }
        
        while (!q.isEmpty()) {
            answer++;
            cur_weight -= q.poll();
            
            if (index < truck_weights.length) {
                int nextTruck = truck_weights[index];
                
                if (cur_weight + nextTruck <= weight) {
                    q.add(nextTruck);
                    cur_weight += nextTruck;
                    index++;
                } else {
                    q.add(0);
                }
            }
        }
        
        return answer;
    }
}