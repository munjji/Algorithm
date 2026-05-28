import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // numbers -> string 배열로 정렬하고.. 다 이어 붙여
        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        
        if (arr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str);
        }
        
        return sb.toString();
    }
}