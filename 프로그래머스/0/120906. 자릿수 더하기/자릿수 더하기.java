class Solution {
    public int solution(int n) {
        int answer = 0;
        String str_n = String.valueOf(n);
        
        for (char c: str_n.toCharArray()) {
            answer += c - '0';
        }
        
        return answer;
    }
}