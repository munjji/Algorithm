import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String s_n = String.valueOf(n);

        for (Character c: s_n.toCharArray()) {
            answer += c - '0';
        }

        return answer;
    }
}