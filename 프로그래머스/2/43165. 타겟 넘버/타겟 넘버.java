import java.util.*;

class Solution {
    static int[] numbers;
    static int target;
        
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        return dfs(0, 0);
    }

    private int dfs(int idx, int sum) {
        if (idx == numbers.length) {
            return sum == target ? 1 : 0;
        }
        
        // 현재 숫자에 +, -를 붙여 다음으로 진행
        int withPlus  = dfs(idx + 1, sum + numbers[idx]);
        int withMinus = dfs(idx + 1, sum - numbers[idx]);
        
        return withPlus + withMinus;
    }
}