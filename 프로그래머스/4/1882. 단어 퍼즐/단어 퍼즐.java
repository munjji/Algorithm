import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        int n = t.length();

        Set<String> set = new HashSet<>();
        for (String s : strs) {
            set.add(s);
        }

        int INF = 100_000_000;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0; 

        for (int i = 1; i <= n; i++) {
            for (int len = 1; len <= 5; len++) {
                if (i - len < 0) break;

                String sub = t.substring(i - len, i);

                if (set.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[i - len] + 1);
                }
            }
        }

        return dp[n] == INF ? -1 : dp[n];
    }
}