import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // dp[1] ~ dp[8] 생성
        // for i = 1 ~ 8:
        //     1) N 붙이기 추가
        //     2) dp[j] + dp[i-j] 조합
        //     3) target 나오면 return i

        // 끝까지 없으면 return -1
        
        // dp[i] = N을 i번 써서 만들 수 있는 모든 숫자들
        List<Set<Integer>> dp = new ArrayList<>();
        
        // N을 최대 8번 사용 가능함
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        for (int i = 1; i <= 8; i++) {
            // N, NN, NNN ...
            int repeatN = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(repeatN);
            
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        // +
                        dp.get(i).add(a + b);
                        // - 
                        dp.get(i).add(a - b);
                        dp.get(i).add(b - a);
                        // *
                        dp.get(i).add(a * b);
                        // /
                        if (b != 0) dp.get(i).add(a / b);
                        if (a != 0) dp.get(i).add(b / a);
                        
                    }
                }
            }
            
            if (dp.get(i).contains(number)) return i;
        }
        
        return -1;
    }
}