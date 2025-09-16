import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] avg_score = new double[score.length];
        
        for (int i = 0 ; i < score.length; i++) {
            avg_score[i] = (double) (score[i][0] + score[i][1]) / 2;
        }
        
        for(int i = 0; i < avg_score.length; i++) {
            int rank = 1;
            for(int j = 0; j < avg_score.length; j++) {
                if(avg_score[i] < avg_score[j]) {
                    rank++;
                }
            }
            answer[i] = rank;
        }
        
        return answer;
    }
}