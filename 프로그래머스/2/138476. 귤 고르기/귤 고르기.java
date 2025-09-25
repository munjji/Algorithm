import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Arrays.sort(tangerine);
        
        HashMap<Integer, Integer> tMap = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            tMap.put(tangerine[i], tMap.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Integer> size_cnt = new ArrayList<>(tMap.values());
        size_cnt.sort(Collections.reverseOrder());
        
        for (Integer cnt: size_cnt) {
            k -= cnt;
            answer++;
            if (k <= 0) return answer;
        }
        return answer;
    }
}