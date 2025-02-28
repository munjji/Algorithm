import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // 완주한 선수들의 이름을 차감
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        // 남아 있는 1명의 선수 찾기
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        
        return ""; // 모든 선수가 완주한 경우 (사실상 문제 조건상 발생하지 않음)
    }
}