import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int len = a.length;
        
        int[] leftMin = new int[len];
        int[] rightMin = new int[len];
        
        leftMin[0] = a[0];
        for (int i = 1; i < len; i++) {
            leftMin[i] = Math.min(a[i], leftMin[i-1]);
        }
        
        rightMin[len-1] = a[len-1];
        for (int i = len - 2; i >= 0; i--) {
            rightMin[i] = Math.min(a[i], rightMin[i+1]);
        }
        
        for (int i = 0; i < len; i++) {
            if (a[i] <= leftMin[i] || a[i] <= rightMin[i]) {
                answer++;
            }
        }
        
        return answer;
    }
}