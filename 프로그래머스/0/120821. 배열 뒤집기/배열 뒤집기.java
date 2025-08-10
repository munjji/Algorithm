import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = Arrays.stream(num_list)
                                   .boxed()
                                   .collect(Collectors.toList());
        Collections.reverse(list);
        int[] answer = list.stream()
                           .mapToInt(Integer::intValue)
                           .toArray();

        return answer;
    }
}