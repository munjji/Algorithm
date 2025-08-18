import java.util.*;

class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> rsp_map = new HashMap<>();
        
        rsp_map.put(2, 0);
        rsp_map.put(0, 5);
        rsp_map.put(5, 2);
        
        for (char c: rsp.toCharArray()) {
            sb.append(rsp_map.get(Character.getNumericValue(c)));
        }
        
        return sb.toString();
    }
}