class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        
        if (direction.equals("right")) {
            for (int i = 0; i < numbers.length; i++) {
                int new_index = (i + 1) % numbers.length;
                answer[new_index] = numbers[i];
            }
        } else {
            for (int i = 0; i < numbers.length; i++) {
                int new_index = (i + numbers.length - 1) % numbers.length;
                answer[new_index] = numbers[i];
            }
        }
        return answer;
    }
}