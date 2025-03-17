// 오른쪽, 아래쪽으로만 움직일 수 있음

import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        // 경로의 개수를 저장하는 DP
        int[][] dp = new int[n + 1][m + 1];
        
        // 물에 잠긴 지역 표시
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        
        dp[1][1] = 1; // 시작 위치 초기화
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 물에 잠긴 지역은 0으로 설정
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i > 1) dp[i][j] += dp[i - 1][j] % MOD;
                if (j > 1) dp[i][j] += dp[i][j - 1] % MOD;
                
                dp[i][j] %= MOD;
            }
        }

        return dp[n][m];
    }
}