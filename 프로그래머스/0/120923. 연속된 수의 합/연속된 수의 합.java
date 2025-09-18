class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int index = 0;
        
        if (num % 2 != 0) {
            int middle = total / num;
            int start = middle - (num / 2);
            int end = middle + (num / 2);

            for (int i = start; i <= end; i++) {
                answer[index] = i;
                index++;
            }
        } else {
            int middle = total / num; // 3
            int start = middle - (num / 2) + 1; // 
            int end = middle + (num / 2);
        
            for (int i = start; i <= end; i++) {
                answer[index] = i;
                index++;
            }
        }
        return answer;
    }
}