import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long min = 1;
        long max = (long)times[times.length-1] * n;
        
        while (min <= max) {
            // 현재 탐색 중인 시간
            long mid = (min + max) / 2;
            // 탐색 인원
            long person = 0;
            
            // 시간 안에 모든 심사관이 n명을 처리할 수 있는지 확인
            for (int time: times) {
                person += mid / time;
                
                if (person >= n) {
                    break;
                }
            }
            
            // mid 값 조정
            if (person >= n) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        
        return answer;        
    }
}