// 첫번째 집과 마지막 집을 동시에 선택할 수 없다는 조건을 활용해 DP로 풀이

import java.util.*;

class Solution {
    public int solution(int[] money) {
        int n = money.length;
        if (n == 1) return money[0];

        int[] dp_includeFirst = new int[n];
        int[] dp_excludeFirst = new int[n];

        // 첫 번째 집 포함 (무조건 첫 번째 집을 포함하겠다는 것 아님. 마지막 집을 선택하지 않겠다는 것임)
        dp_includeFirst[0] = money[0];
        dp_includeFirst[1] = Math.max(money[0], money[1]);
        for (int i = 2; i < n - 1; i++) {
            dp_includeFirst[i] = Math.max(dp_includeFirst[i - 1], dp_includeFirst[i - 2] + money[i]);
        }

        // 첫 번째 집 제외
        dp_excludeFirst[0] = 0;
        dp_excludeFirst[1] = money[1];
        for (int i = 2; i < n; i++) {
            dp_excludeFirst[i] = Math.max(dp_excludeFirst[i - 1], dp_excludeFirst[i - 2] + money[i]);
        }

        return Math.max(dp_includeFirst[n - 2], dp_excludeFirst[n - 1]);
    }
}