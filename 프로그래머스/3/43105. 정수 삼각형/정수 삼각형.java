// 밑에서부터 밑의 배열[i]의 위의 배열[i-1]과 배열[i]를 합한 값 중에 max 값 골라주고 더해주기
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int[][] dp = new int[height][height];
        
        // 맨 아랫 줄만 그대로 복사
        for (int i = 0; i < height; i++) {
            dp[height-1][i] = triangle[height-1][i];
        }
        
        for (int i = height-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}