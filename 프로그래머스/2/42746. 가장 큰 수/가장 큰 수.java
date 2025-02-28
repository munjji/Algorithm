// 참고한 풀이..
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        
        String[] strNumbers = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .toArray(String[]::new);
        
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));
    
        for (String number: strNumbers) {
            sb.append(number);
        }
        
        if (sb.toString().charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}