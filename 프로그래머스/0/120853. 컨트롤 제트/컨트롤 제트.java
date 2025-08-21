class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] s_split = s.split(" ");
        
        for (int i = 0; i < s_split.length; i++) {
            if (s_split[i].equals("Z")) {
                answer -= Integer.parseInt(s_split[i-1]);
            } else {
                answer += Integer.parseInt(s_split[i]);
            }
        }
        return answer;
    }
}