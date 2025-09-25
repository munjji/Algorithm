import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int x = -1, y = 0; 
        int num = 1;        
        int max = n * (n + 1) / 2;

        // step은 삼각형의 몇번째 방향인지
        for (int step = 0; step < n; step++) {
            for (int i = step; i < n; i++) {
                if (step % 3 == 0) { // 아래로
                    x++;
                } else if (step % 3 == 1) { // 오른쪽
                    y++;
                } else { // 위로
                    x--;
                    y--;
                }
                triangle[x][y] = num++;
            }
        }

        int[] answer = new int[max];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = triangle[i][j];
            }
        }

        return answer;
    }
}