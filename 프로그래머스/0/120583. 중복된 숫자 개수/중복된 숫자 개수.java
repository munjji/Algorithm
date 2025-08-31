import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        List<Integer> list = Arrays.stream(array)
                            .boxed()
                            .collect(Collectors.toList());
        answer = Collections.frequency(list, n);
        return answer;
    }
}