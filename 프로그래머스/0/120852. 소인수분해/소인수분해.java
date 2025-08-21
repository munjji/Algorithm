import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                set.add(i);
                n /= i;
            }
        }
        
        if (n > 1) {
            set.add(n);
        }
        
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}