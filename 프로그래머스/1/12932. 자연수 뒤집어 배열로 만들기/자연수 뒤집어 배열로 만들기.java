import java.util.*;
class Solution {
    public int[] solution(long n) {
        String s_n = Long.toString(n);
        List<Integer> list = new ArrayList<>();
        for (int i = s_n.length() - 1; i >= 0; i--) {
            list.add(s_n.charAt(i) - '0');
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}