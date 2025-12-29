import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int n = sequence.length;
        int bLen = Integer.MAX_VALUE;
        int sum = 0, l = 0;
        
        for (int r = 0; r < n; r++) {
            sum += sequence[r];
            
            while (sum > k) {
                sum -= sequence[l++];
            }
            
            if (sum == k) {
                int len = r - l;
                
                if (len < bLen) {
                    bLen = len;
                    answer[0] = l;
                    answer[1] = r;
                }
            }
        }
        
        return answer;
    }
}