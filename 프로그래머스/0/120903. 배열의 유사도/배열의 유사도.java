import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        List<String> s1List = new ArrayList<>(Arrays.asList(s1));
        
        for (int i = 0; i < s2.length; i++) {
            if (s1List.contains(s2[i])) answer++;
        }
        return answer;
    }
}