import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        final int MOD = 1_000_000_007;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        
        for (int coin : money) {
            for (int sum = coin; sum <= n; sum++) {
                dp[sum] = (dp[sum] + dp[sum - coin]) % MOD;
            }
        }

        return (int) dp[n];
    }
}