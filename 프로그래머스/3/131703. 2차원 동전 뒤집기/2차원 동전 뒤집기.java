import java.util.*;

class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int N = beginning.length;
        int M = beginning[0].length;
        int answer = Integer.MAX_VALUE;

        // 행 선택을 비트마스크로 표현 (0 ~ (1<<N)-1)
        for (int mask = 0; mask < (1 << N); mask++) {
            int[][] board = copy(beginning);
            int flipCount = 0;

            // 선택된 행 뒤집기
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    flipRow(board, i);
                    flipCount++;
                }
            }

            // 열 뒤집기 여부 결정
            boolean possible = true;
            for (int j = 0; j < M; j++) {
                if (board[0][j] != target[0][j]) {
                    flipCol(board, j);
                    flipCount++;
                }
            }

            if (equals(board, target)) {
                answer = Math.min(answer, flipCount);
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void flipRow(int[][] board, int row) {
        for (int j = 0; j < board[0].length; j++) {
            board[row][j] ^= 1;
        }
    }

    private void flipCol(int[][] board, int col) {
        for (int i = 0; i < board.length; i++) {
            board[i][col] ^= 1;
        }
    }

    private int[][] copy(int[][] arr) {
        int[][] newArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i].clone();
        }
        return newArr;
    }

    private boolean equals(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
}