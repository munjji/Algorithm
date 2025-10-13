import java.util.*;

class Solution {
    public int solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast() == c) {
                stack.removeLast();
            } else {
                stack.addLast(c);
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}