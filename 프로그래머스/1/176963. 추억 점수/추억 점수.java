import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for (int j = 0; j < photo.length; j++) {
            int total = 0;
            String[] pho = photo[j];
            for (int i = 0 ; i < pho.length; i++) {
                if (map.containsKey(pho[i])) {
                    total += map.get(pho[i]);
                }
            }
            answer[j] = total;
        }
        return answer;
    }
}