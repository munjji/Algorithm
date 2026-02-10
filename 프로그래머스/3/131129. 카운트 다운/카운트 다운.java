import java.util.*;

class Solution {
    public int[] solution(int target) {
        int INF = 1_000_000;
        List<int[]> darts = new ArrayList<>();
        
        // 불일 경우 (싱글 || 불 = 1)
        darts.add(new int[]{50, 1});
        
        // 싱글일 경우 (싱글 || 불 = 1)
        for (int i = 1; i <= 20; i++) {
            darts.add(new int[]{i, 1});
        }
        
        // 더블, 트리플일 경우 (싱글 || 불 = 0)
        for (int i = 1; i <= 20; i++) {
            darts.add(new int[]{2 * i, 0});
            darts.add(new int[]{3 * i, 0});
        }
        
        int[][] dp = new int[target + 1][2];
        for (int i = 1; i <= target; i++) {
            dp[i][0] = INF;
            dp[i][1] = -INF;
        }
        
        for (int i = 1; i <= target; i++) {
            for (int[] dart : darts) {
                int score = dart[0];
                int bonus = dart[1]; // 싱글 또는 불이면 1
                
                if (i - score < 0) continue;
                
                int prev = i - score;
                int candDarts = dp[prev][0] + 1;
                int candSingles = dp[prev][1] + bonus;
                
                // 우선순위
                // 1. 다트 수 최소 2. 다트 수 같으면 싱글/불 최대
                if (candDarts < dp[i][0]) {
                    dp[i][0] = candDarts;
                    dp[i][1] = candSingles;
                } else if (candDarts == dp[i][0]
                          && candSingles > dp[i][1]) {
                    dp[i][1] = candSingles;
                }
            }
        }
        
        return new int[]{dp[target][0], dp[target][1]};
    }
}