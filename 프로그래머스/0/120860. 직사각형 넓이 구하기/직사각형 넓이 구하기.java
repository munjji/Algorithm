class Solution {
    public int solution(int[][] dots) {
        int width = 0;
        int height = 0;
        
        for (int i = 0 ; i < dots.length; i++) {
            if (dots[0][0] == dots[i][0]) {
                width = Math.abs(dots[0][1] - dots[i][1]);
            }
            
            if (dots[0][1] == dots[i][1]) {
                height = Math.abs(dots[0][0] - dots[i][0]);
            }
        }
        
        return width * height;
    }
}