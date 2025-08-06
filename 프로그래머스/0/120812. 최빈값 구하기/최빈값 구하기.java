import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        
        if (array.length == 1) {
            answer = array[0];
            return answer;
        }
        
        for (int number : array) {
            countMap.put(number, countMap.getOrDefault(number, 0) + 1);
        }

        // value 기준으로 정렬
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(countMap.entrySet());
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue())); // 내림차순

        // 최대값과 비교
        int maxValue = entryList.get(0).getValue();
        if (entryList.size() > 1 && entryList.get(1).getValue() == maxValue) {
            answer = -1; 
        } else {
            answer = entryList.get(0).getKey();
        }

        return answer;
    }
}