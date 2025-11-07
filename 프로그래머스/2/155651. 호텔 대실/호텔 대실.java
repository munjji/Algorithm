import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int n = book_time.length;
        int[][] times = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            int start = toMinute(book_time[i][0]);
            int end = toMinute(book_time[i][1]) + 10; 
            times[i][0] = start;
            times[i][1] = end;
        }
        
        Arrays.sort(times, (a, b) -> a[0] - b[0]);
        
        // 현재 사용 중인 방들의 "비는 시간"을 담는 최소힙
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int start = times[i][0];
            int end = times[i][1];
            
            // 이미 청소까지 끝나서 재사용 가능한 방들 제거
            while (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            
            // 현재 예약을 새로 하나 배정 (혹은 재사용 방에 배정)
            pq.offer(end);
            
            // 현재 동시에 쓰는 방 개수의 최댓값 갱신
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
    
    private int toMinute(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }
}