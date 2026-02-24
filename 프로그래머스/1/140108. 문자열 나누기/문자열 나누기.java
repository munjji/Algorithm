import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char first = s.charAt(0);
        int same = 1;
        int not = 0;
        
        if (s.length() == 1) return 1;
        
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (first == c) same++;
            else not++;
            
            if (same == not) {
                answer++;
                same = 0;
                not = 0;
                if (i+1 < s.length()) first = s.charAt(i+1);
                else break;
            }
            
            if (i == s.length() - 1 && same > not) answer++;
        }
        
        return answer;
    }
}