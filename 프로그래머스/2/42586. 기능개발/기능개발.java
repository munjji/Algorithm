// Stack, Queue => 앞에서 부터 빠져야 하니까 Queue 사용
// day = 100 - progresses[i] / speeds[i];
// progresses = [7, 3, 9]으로 재정의 하기
// 처음 거랑 그 다음 거랑 비교해서 만약에 그 다음 게 작으면 같이 remove 하자
// 개수 세서 speeds에 추가하자

// 반례입니다.
// 입력값 〉 [90, 90], [10, 9] => [1, 2]
// 기댓값 〉 [1, 1]
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> proQueue = new LinkedList<>();
        
        // 재구성한 큐 생성
        for (int i = 0; i < progresses.length; i++) {
            int remaining = 100 - progresses[i];
            int day = (remaining % speeds[i] == 0) ? remaining / speeds[i] : (remaining / speeds[i]) + 1;
            proQueue.offer(day);
        }
        
        int first = proQueue.poll();
        int count = 1;
        
        // 개수 세기
        while (!proQueue.isEmpty()) {
            int next = proQueue.peek();
            
            if (first >= next) {
                proQueue.poll();
                count++;
            } else {
                answerList.add(count);
                count = 1;
                first = proQueue.poll();
            }
        }
        
        answerList.add(count);
        
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}