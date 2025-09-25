import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] string_array = s.split(" ");
        int[] int_array = new int[string_array.length];
        int sum = 0; 
        
        for (int i = 0; i < string_array.length; i++) {
            int_array[i] = Integer.parseInt(string_array[i]);
        }
        
        Arrays.sort(int_array);
        sb.append(int_array[0]);
        sb.append(" ");
        sb.append(int_array[int_array.length - 1]);
        return sb.toString();
    }
}