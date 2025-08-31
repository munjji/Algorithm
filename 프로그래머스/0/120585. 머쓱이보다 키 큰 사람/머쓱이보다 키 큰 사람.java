import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        for (int h : array) {
            if (h > height) answer++;
        }
        return answer;
    }
}