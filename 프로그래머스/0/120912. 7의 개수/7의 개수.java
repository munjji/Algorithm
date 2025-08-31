class Solution {
    public int solution(int[] array) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int num: array) {
            sb.append(String.valueOf(num));
        }
        
        for (char c: sb.toString().toCharArray()) {
            if (c == '7') answer++;
        }
        
        return answer;
    }
}