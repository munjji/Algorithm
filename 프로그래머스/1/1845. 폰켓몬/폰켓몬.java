import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int N = nums.length;
        int number = N / 2;
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                answer++;
            }
        }
        
        if (number < answer) {
            answer = number;
        }
        
        return answer;
    }
}