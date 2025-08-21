import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 0;
        int paintedUntil = 0;
        
        for (int s : section) {
            if (s > paintedUntil) {    
                count++;                 
                paintedUntil = s + m - 1; 
                if (paintedUntil > n) {
                    paintedUntil = n;
                }
            }
        }
        
        return count;
    }
}