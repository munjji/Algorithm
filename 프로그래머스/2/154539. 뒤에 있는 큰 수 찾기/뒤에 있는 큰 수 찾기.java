import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = numbers.length-1; i >= 0; i--) {
            int cur = numbers[i];
            
            while (!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = stack.peek();
            }
            
            stack.push(cur);
        }
        
        return answer;
    }
}