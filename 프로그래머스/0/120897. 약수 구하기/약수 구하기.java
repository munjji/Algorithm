import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> set = new TreeSet<>(); // 정렬 가능한 Set = treeSet
        
        for (int i = 1; i < n / 2; i++) {
            if (n % i == 0) {
                int goap = n / i;
                set.add(i);
                set.add(goap);
            }
        }
        
        if (n == 1) {
            set.add(1);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}