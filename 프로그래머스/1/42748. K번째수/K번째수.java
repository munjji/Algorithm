import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        List<Integer> list = new ArrayList<>();
        
        for (int t = 0; t < commands.length; t++) {
            int i = commands[t][0];
            int j = commands[t][1];
            int k = commands[t][2];
            
            for (int idx = i - 1; idx < j; idx++) {
                list.add(array[idx]);
            }
            
            Collections.sort(list);
            answer[t] = list.get(k - 1);
            list.clear();
        }
        
        return answer;
    }
}