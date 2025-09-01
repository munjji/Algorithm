import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        int pos_max = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        int neg_max = numbers[0] * numbers[1];
        answer = pos_max >= neg_max ? pos_max : neg_max;
        return answer;
    }
}