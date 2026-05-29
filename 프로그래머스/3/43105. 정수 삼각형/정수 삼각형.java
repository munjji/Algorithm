import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int h = triangle.length;
        int[][] dp = new int[h][h];
        
        for (int i = 0; i < h; i++) {
            dp[h - 1][i] = triangle[h - 1][i];
        }
        
        for (int i = h - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        
        return dp[0][0];
    }
}