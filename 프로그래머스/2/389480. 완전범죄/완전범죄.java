import java.util.*;

class Solution {
    static final int INF = 10000;
    
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        int size = info.length;
        // B 도둑 흔적 j에 따라 A 도둑의 최소 흔적을 저장
        int[][] dp = new int[size+1][m+1]; // DP 테이블 (A 도둑 흔적을 저장)
                        
        // DP 배열 무한대로 초기화 (최솟값 찾을 거니까)
        for (int i = 0; i <= size; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;
        
        // 모든 물건을 하나씩 처리
        for (int i = 1; i <= size; i++) {
            int a = info[i-1][0];
            int b = info[i-1][1];
            
            // B 도둑 기준으로 모든 경우의 수 탐색
            for (int j = 0; j <=m; j++) {
                // 1. A도둑이 현재 물건을 훔치는 경우
                // 기존 흔적 값에 A의 흔적 값을 추가
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);
                // 2. B 도둑이 현재 물건을 훔치는 경우
                // B의 흔적이 m을 넘지 않는다면, 기존 A 도둑의 흔적 값을 유지
                if (j + b <= m) {
                    dp[i][j + b] = Math.min(dp[i][j + b], dp[i-1][j]);
                }
            }
        }
        
        int minA = INF;
            
        for (int j = 0; j < m; j++) {
            minA = Math.min(dp[size][j], minA);
        }
        
        answer = (minA >= n) ? -1 : minA;
        
        return answer;
    }
}