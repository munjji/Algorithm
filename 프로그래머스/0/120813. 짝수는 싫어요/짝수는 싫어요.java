class Solution {
    public int[] solution(int n) {
        int number = (n + 1) / 2;
        int[] answer = new int[number];
        
        for (int i = 0; i < number; i++) {
            answer[i] = (i * 2) + 1;
        }
        return answer;
    }
}