class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int maxVal = Integer.MIN_VALUE;
        int maxIdx = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
                maxIdx = i;
            }
        }
        answer[0] = maxVal;
        answer[1] = maxIdx;
        
        return answer;
    }
}