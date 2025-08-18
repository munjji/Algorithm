import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        Integer[] sorted = Arrays.stream(emergency).boxed().toArray(Integer[]::new);
        Arrays.sort(sorted, Collections.reverseOrder());
        
        Map<Integer, Integer> ranking_map = new HashMap<>();
        for (int i = 0; i < emergency.length; i++) {
            ranking_map.put(sorted[i], i+1);
        }
        
        for (int i = 0; i < emergency.length; i++) {
            answer[i] = ranking_map.get(emergency[i]);
        }
        return answer;
    }
}