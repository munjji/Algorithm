import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        int m = times.length;
        Arrays.sort(times);
        
        long min = 1;
        long max = (long) n * times[m - 1];
        
        while (min <= max) {
            long mid = (min + max) / 2;
            long person = 0;
            
            for (int time: times) {
                person += mid / time;
                
                if (person >= n) {
                    break;
                }
            }
            
            if (person >= n) {
                max = mid - 1;
                answer = mid;
            } else {
                min = mid + 1;
            }
        }
        
        return answer;        
    }
}