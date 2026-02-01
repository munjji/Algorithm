class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        // s를 공백을 기준으로 나눠서 String[]에 저장
        // 돌면서 짝수번째 -> 대문자, 홀수번째 -> 소문자로 바꾸기
        
        String[] split_s = s.split(" ", -1);
        
        for (String split : split_s) {
            for (int i = 0; i < split.length(); i++) {
                char c = split.charAt(i);
                if (i % 2 == 0) sb.append(Character.toUpperCase(c));
                else sb.append(Character.toLowerCase(c));
            }
            
            sb.append(" ");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}