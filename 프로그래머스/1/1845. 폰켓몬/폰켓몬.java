import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int N = nums.length;
        int number = N / 2;
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                answer++;
            }
        }
        
        if (number < answer) {
            answer = number;
        }
        
        return answer;
    }
}