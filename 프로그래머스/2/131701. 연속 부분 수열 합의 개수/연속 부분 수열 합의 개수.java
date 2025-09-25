import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        HashSet<Integer> set = new HashSet<>();
        
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = elements[i % n];
        }
        
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start < n; start++) {
                int sum = 0;
                for (int k = start; k < start + len; k++) {
                    sum += arr[k];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}