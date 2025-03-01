import java.util.*;

class Solution {
    static class Process {
        int index;
        int priority;
        
        public Process(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Process> processes = new LinkedList<>();
        PriorityQueue<Integer> remainPriority = new PriorityQueue<>(Collections.reverseOrder());
        
        // 인덱스랑 우선순위 저장한 큐, 우선순위 내림차순으로 저장한 우선순위큐
        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            remainPriority.add(priority);
            processes.add(new Process(i, priority));
        }
        
        int order = 1;
        while(true) {
            Process ready = processes.poll();
            int maxPriority = remainPriority.poll();
        
            if(maxPriority == ready.priority) {
                if(location == ready.index) {
                    return order;
                } else {
                    order++;
                }
            } else {
                remainPriority.add(maxPriority);
                processes.add(ready);
            }
        }
    }
}