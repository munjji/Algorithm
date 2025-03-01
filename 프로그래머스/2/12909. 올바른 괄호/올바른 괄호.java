import java.util.*;

class Solution {
    public boolean solution(String s) {        
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else { // c == ')'
                if (stack.isEmpty()) {
                    return false; // 닫는 괄호가 먼저 나오면 잘못된 문자열
                }
                stack.pop(); // 올바른 짝이 맞으면 제거
            }
        }

        // 스택이 비어 있으면 올바른 괄호 문자열, 아니면 false
        return stack.isEmpty();
    }
}