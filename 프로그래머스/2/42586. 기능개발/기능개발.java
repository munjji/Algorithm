// day = (100 - progresses[i]) / speeds[i];
// progresses = [7, 3, 9]으로 재정의 하기
// 처음 거랑 그 다음 거랑 비교해서 만약에 그 다음 게 작으면 같이 remove 하자
// 개수 세서 speeds에 추가하자

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
        
        int cur = proQueue.poll();
        int count = 1;
        
        // 개수 세기
        while (!proQueue.isEmpty()) {
            int next = proQueue.peek();
            
            if (cur >= next) {
                proQueue.poll();
                count++;
            } else {
                answerList.add(count);
                count = 1;
                cur = proQueue.poll();
            }
        }
        
        answerList.add(count);
        int[] answer = new int[answerList.size()];
        for (int i = 0 ; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}