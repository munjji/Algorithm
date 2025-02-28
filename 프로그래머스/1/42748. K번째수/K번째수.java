import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num); 
        }
                
        for (int i = 0; i < commands.length; i++) {
            List<Integer> subList = new ArrayList<>(list.subList(commands[i][0] - 1, commands[i][1]));
            Collections.sort(subList);
            answer[i] = subList.get(commands[i][2] - 1);
        }
        
        return answer;
    }
}