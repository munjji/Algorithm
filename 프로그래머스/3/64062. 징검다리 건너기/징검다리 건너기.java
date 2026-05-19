import java.util.*;

class Solution {
    
    static int[] stones;
    static int k;
    
    public int solution(int[] stones, int k) {
        int n = stones.length;
        this.k = k;
        this.stones = stones;
        
        int answer = 0;
        int left = 1;
        int right = Arrays.stream(stones).max().getAsInt();
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (canCross(mid, stones)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    static boolean canCross(int mid, int[] stones) {
        int cnt = 0;
        
        for (int stone : stones) {
            if (stone - mid < 0) {
                cnt++;
            } else {
                cnt = 0;
            }
            
            if (cnt >= k) return false;
        }
        
        return true;
    }
}