import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> string_idx_map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            boolean isFind = false;
            for (Character c : string_idx_map.keySet()) {
                if (s.charAt(i) == c) {
                    answer[i] = i - string_idx_map.get(c);
                    isFind = true;
                    break;
                } 
            }
            
            if (!isFind) {
                answer[i] = -1;
            }
            string_idx_map.put(s.charAt(i), i);
        }
        
        return answer;
    }
}