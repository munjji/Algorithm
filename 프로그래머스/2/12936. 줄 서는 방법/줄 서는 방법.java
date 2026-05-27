// k번째 순열 직접 찾기
import java.util.*;

class Solution {
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> nums = new ArrayList<>();
        
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            
            if (i < n) {
                fact *= i;
            }
        }
        
        k--;
        for (int i = 0; i < n; i++) {
            int idx = (int) (k / fact);
            answer[i] = nums.remove(idx);
            
            if (i == n - 1) break;
            
            k %= fact;
            fact /= (n - 1 - i);
        }
        
        return answer;
    }
}