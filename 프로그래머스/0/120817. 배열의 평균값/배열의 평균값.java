class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        
        for (Integer number:numbers) {
            answer += number;
        }
        answer = (double) answer/numbers.length;
        return answer;
    }
}