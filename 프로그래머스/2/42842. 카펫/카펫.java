class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int n = brown + yellow;
        int h = 0;
        
        for (int i = brown / 2; i > 0 ; i--) {
            if (n % i == 0) {
                h = n / i;
            }
            
            if (i * 2 + 2 * h - 4 == brown && (i -2) * (h-2) == yellow) {
                answer[0] = i;
                answer[1] = h;
                break;
            }
        }
        return answer;
    }
}