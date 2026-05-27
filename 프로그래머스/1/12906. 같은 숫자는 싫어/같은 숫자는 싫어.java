import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        
        for (int a : arr) {
            if (a != stack.peek()) stack.push(a);
        }
        
        // 뒤부터 pop
        answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}