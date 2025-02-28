import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        int total_clothes = clothes.length;
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] cloth: clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        
        for (int count: map.values()) {
            // 아무것도 선택하지 않는 경우도 포함해야 하므로 1을 더함
            answer *= (count+1);
        }
        
        // 아무것도 입지 않는 경우는 제외해야함
        return answer-1;
    }
}