import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = discount.length;
        int WIN = 10;
        if (n < WIN) return 0;
        
        HashMap<String, Integer> want_map = new HashMap<>();
        HashMap<String, Integer> window = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            want_map.put(want[i], number[i]);
        }
        
        for (int i = 0; i < WIN; i++) {
            window.put(discount[i], window.getOrDefault(discount[i], 0) + 1);
        }
        
        if (satisfy(want_map, window)) answer++;
        
        for (int i = 1; i <= n - WIN; i++) {
            String out = discount[i-1];
            String in = discount[i + WIN - 1];
            
            int cnt_out = window.get(out) - 1;
            if (cnt_out == 0) window.remove(out);
            else window.put(out, cnt_out);
            
            window.put(in, window.getOrDefault(in, 0) + 1);
            
            if (satisfy(want_map, window)) answer++;
        }
        
        return answer;
    }
        
    private boolean satisfy(Map<String, Integer> want, Map<String, Integer> win) {
        for (Map.Entry<String, Integer> e : want.entrySet()) {
            if (win.getOrDefault(e.getKey(), 0) < e.getValue()) return false;
        }
        return true;
    }
}