class Solution {
    public int solution(int[][] dots) {
        
        if (isParallel(dots[0], dots[1], dots[2], dots[3])) return 1;
        if (isParallel(dots[0], dots[2], dots[3], dots[1])) return 1;
        if (isParallel(dots[0], dots[3], dots[1], dots[2])) return 1;
        
        return 0;
    }
    
    private final boolean isParallel (int[] a, int[] b, int[] c, int[] d) {
        int dx1 = a[0] - b[0];
        int dy1 = a[1] - b[1];
        int dx2 = c[0] - d[0];
        int dy2 = c[1] - d[1];
        
        return dy1 * dx2 == dy2 * dx1;
    }
}