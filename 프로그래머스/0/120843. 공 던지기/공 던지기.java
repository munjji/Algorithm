class Solution {
    public int solution(int[] numbers, int k) {
        int target_index = (k - 1) * 2;
        
        if (numbers.length > target_index) {
            return numbers[target_index];
        } else {
            return numbers[target_index % numbers.length];
        }
    }
}