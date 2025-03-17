import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] no1 = {1, 2, 3, 4, 5};
        int[] no2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] no3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int no1Cnt = 0, no2Cnt = 0, no3Cnt = 0;
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == no1[i % no1.length]) no1Cnt++;
            if (answers[i] == no2[i % no2.length]) no2Cnt++;    
            if (answers[i] == no3[i % no3.length]) no3Cnt++;
        }
        
        int[] cntArray = {no1Cnt, no2Cnt, no3Cnt};
        int maxScore = Math.max(no1Cnt, Math.max(no2Cnt, no3Cnt));
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (cntArray[i] == maxScore) {
                result.add(i + 1);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}