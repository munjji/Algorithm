// 가장 큰 숫자를 하나고르기
// 각 명함 배열 마다 최대값을 제외한 나머지 원소 값들 중 가장 큰 값을 고르기
// 
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        HashSet<Integer> max_set = new HashSet<>();
        HashSet<Integer> min_set = new HashSet<>();
        
        for (int i =0; i < sizes.length; i++) {
            int min = Math.min(sizes[i][0], sizes[i][1]);
            int max = Math.max(sizes[i][0], sizes[i][1]);
            max_set.add(max);
            min_set.add(min);
        }
        
        return Collections.max(max_set)*Collections.max(min_set);
    }
}