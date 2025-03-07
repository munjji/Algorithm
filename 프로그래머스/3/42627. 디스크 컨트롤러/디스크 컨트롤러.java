// 작업의 번호, 작업의 요청 시각, 작업의 소요 시간 - 대기 큐
// 우선순위 -> 소요 시간 소, 요청 시간 소, 작업의 번호 소
// 하드디스크 작업 x && !대기 큐.isEmpty() => 대기 큐. poll()해서 하드디스크 작업

import java.util.*;

class Solution {
    
    class Process {
        public int number;
        public int request_time;
        public int processing_time;
        
        public Process(int number, int request_time, int processing_time) {
            this.number = number;
            this.request_time = request_time;
            this.processing_time = processing_time;
        }
    }
    
    class ProcessComparator implements Comparator<Process> {
        @Override
        public int compare(Process p1, Process p2) {
            if (p1.processing_time != p2.processing_time) {
                return Integer.compare(p1.processing_time, p2.processing_time);
            }
            if (p1.request_time != p2.request_time) {
                return Integer.compare(p1.request_time, p2.request_time);
            }
            return Integer.compare(p1.number, p2.number);
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        // 디스크 대기 큐
        PriorityQueue<Process> disk = new PriorityQueue<>(Comparator.comparingInt(p -> p.request_time));
        int number = 0;
        
        for (int[] job: jobs) {
            disk.offer(new Process(++number, job[0], job[1]));
        }
        
        // 현재 시간
        int time = 0;
        // 하드디스크가 처리하고 있는 작업 목록
        PriorityQueue<Process> exec_list = new PriorityQueue<>(new ProcessComparator());
    
        while (!disk.isEmpty() || !exec_list.isEmpty()) {
            while (!disk.isEmpty() && time >= disk.peek().request_time) {
                exec_list.offer(disk.poll());
            }

            if (!exec_list.isEmpty()) {
                Process exec = exec_list.poll();
                if (time < exec.request_time) {
                    time = exec.request_time;
                }
                time += exec.processing_time;
                answer += time - exec.request_time;
            } else if (!disk.isEmpty()) {
                time = disk.peek().request_time;
            }
        }
    
        
        return answer / jobs.length;
    }
}