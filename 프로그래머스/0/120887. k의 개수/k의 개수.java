class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int start = i; start <= j; start++) {
            sb.append(start);
        }
                
        for (int a = 0 ; a < sb.length(); a++) {
            char c = sb.charAt(a);
            if (c == (char) ('0' + k)) answer++;
        }
        
        return answer;
    }
}