import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>(); // 보조 벨트
        int idx = 0; // order 인덱스

        for (int box = 1; box <= order.length; box++) {
            // 벨트에서 꺼낸다
            if (box == order[idx]) {
                answer++;
                idx++;

                // 스택에서도 계속 꺼낼 수 있으면 꺼낸다
                while (!stack.isEmpty() && stack.peek() == order[idx]) {
                    stack.pop();
                    answer++;
                    idx++;
                }
            } else {
                stack.push(box);
            }
        }
    
        return answer;
    }
}