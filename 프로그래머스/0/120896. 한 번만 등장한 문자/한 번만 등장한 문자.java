import java.util.*;

class Solution {
    public String solution(String s) {
        // 문자 빈도 세기
        int[] freq = new int[26];
        
        for (char c: s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // 등장 횟수가 1인 문자만 추출
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 1) {
                list.add((char)(i + 'a'));
            }
        }
        
        // 사전순 정렬
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}