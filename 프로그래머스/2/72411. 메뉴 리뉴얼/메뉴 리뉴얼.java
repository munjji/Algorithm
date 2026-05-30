import java.util.*;

class Solution {
    
    static Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        
        List<String> list = new ArrayList<>();
        
        for (int len : course) {
            map = new HashMap<>();
            
            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                
                dfs(arr, "", 0, len);
            }
            
            int max = 0;
            for (int value : map.values()) {
                max = Math.max(max, value);
            }
            
            if (max < 2) continue;
            
            for (String menu : map.keySet()) {
                if (map.get(menu) == max) {
                    list.add(menu);
                }
            }
        }
        
        Collections.sort(list);
        
        return list.toArray(new String[0]);
    }
    
    static private void dfs (char[] order, String current, int start, int len) {
        if (current.length() == len) {
            map.put(current, map.getOrDefault(current, 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length; i++) {
            dfs(order, current + order[i], i + 1, len);
        }
    }
}