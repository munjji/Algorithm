import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int[][] pos = {
            {3,1}, // 0
            {0,0}, {0,1}, {0,2},
            {1,0}, {1,1}, {1,2},
            {2,0}, {2,1}, {2,2}
        };

        int[] left = {3,0}; 
        int[] right = {3,2};

        for (int n : numbers) {
            if (n == 1 || n == 4 || n == 7) {
                sb.append("L");
                left = pos[n];
            } else if (n == 3 || n == 6 || n == 9) {
                sb.append("R");
                right = pos[n];
            } else {
                int[] target = (n == 0) ? pos[0] : pos[n];
                int leftDis = Math.abs(left[0] - target[0]) + Math.abs(left[1] - target[1]);
                int rightDis = Math.abs(right[0] - target[0]) + Math.abs(right[1] - target[1]);

                if (leftDis < rightDis) {
                    sb.append("L");
                    left = target;
                } else if (rightDis < leftDis) {
                    sb.append("R");
                    right = target;
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        right = target;
                    } else {
                        sb.append("L");
                        left = target;
                    }
                }
            }
        }

        return sb.toString();
    }
}