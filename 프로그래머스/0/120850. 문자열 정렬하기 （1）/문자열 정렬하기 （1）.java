import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        String onlyDigits = my_string.replaceAll("[a-z]", "");
        
        int[] answer = new int[onlyDigits.length()];
        for (int i = 0; i < onlyDigits.length(); i++) {
            answer[i] = onlyDigits.charAt(i) - '0';
        }
        Arrays.sort(answer);
        return answer;
    }
}