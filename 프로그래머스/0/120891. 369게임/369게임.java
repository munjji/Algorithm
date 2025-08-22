import java.util.*;

class Solution {
    public int solution(int order) {
        int answer = 0;
        Character[] tsn = {'3', '6', '9'};
        List<Character> tsnList = new ArrayList<>(Arrays.asList(tsn));
        for (Character o: Integer.toString(order).toCharArray()) {
            if (tsnList.contains(o)) {
                answer++;
            }
        }
        return answer;
    }
}