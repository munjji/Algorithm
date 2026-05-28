class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int n = brown + yellow;
        int h = 0;
        
        for (int w = brown / 2; w > 0 ; w--) {
            if (n % w == 0) {
                h = n / w;
            }
            
            if ((w * 2) + (h * 2) - 4 == brown && (w - 2) * (h - 2) == yellow) {
                answer[0] = w;
                answer[1] = h;
                break;
            }
        }
        
        return answer;
    }
}