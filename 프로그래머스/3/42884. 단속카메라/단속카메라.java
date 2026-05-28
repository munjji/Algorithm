import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int n = routes.length;
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        // 1. routes를 진출 지점 기준 정렬
//         2. camera 위치를 아주 작은 값으로 시작
//             3. 각 차량을 보면서
//            - 현재 camera가 이 차량 구간 안에 있으면 패스

//            - 없으면 이 차량의 진출 지점에 새 camera 설치
        
        int answer = 1;
        int camera = routes[0][1];
        for (int i = 1; i < n; i++) {
            int start = routes[i][0];
            int end = routes[i][1];
            
            if (camera < start) {
                camera = end;
                answer++;
            }
        }
        
        return answer;
    }
}