import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int min_diff = Math.abs(n-array[0]);
        int min_idx = 0;
        for (int i = 0; i < array.length; i++) {
            if (min_diff > Math.abs(n-array[i])) {
                min_diff = Math.abs(n-array[i]);
                min_idx = i;
                answer = Math.min(array[i], array[min_idx]);
                System.out.println(min_diff);
            } else if (min_diff == Math.abs(n-array[i])) {
                answer = Math.min(array[i], array[min_idx]);
            }
        }
        return answer;
    }
}