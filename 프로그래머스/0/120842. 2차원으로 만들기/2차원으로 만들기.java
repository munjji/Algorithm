import java.util.*;

class Solution {
    public int[][] solution(int[] num_list, int n) {
        int m = num_list.length / n;
        int[][] answer = new int[m][n];
        int index = 0;
        
        for (int i = 0; i < m; i++) {
            answer[i] = Arrays.copyOfRange(num_list, index, index + n);
            index += n;
        }
        return answer;
    }
}