import java.io.*;
import java.util.*;

public class Main {

    static class Shark {
        int r, c, s, d, k;
        Shark(int r, int c, int s, int d, int k) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.k = k;
        }
    }

    static int R, C, M;
    static Shark[][] board;

    // d: 1 위, 2 아래, 3 오른쪽, 4 왼쪽
    static final int UP = 1, DOWN = 2, RIGHT = 3, LEFT = 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new Shark[R+1][C+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine().trim());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Shark shark = new Shark(r, c, s, d, k);
            board[r][c] = shark;
        }

        int answer = 0;

        for (int i = 1; i <= C; i++) {
            answer += catchShark(i);
            board = moveAll();
        }

        System.out.println(answer);
    }

    private static int catchShark(int col) {
        for (int r = 1; r <= R; r++) {
            if (board[r][col] != null) {
                int k = board[r][col].k;
                board[r][col] = null;
                return k;
            }
        }
        return 0;
    }

    private static Shark[][] moveAll() {
        Shark[][] next = new Shark[R+1][C+1];

        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                Shark shark = board[r][c];
                if (shark == null) continue;

                Shark moved = moveOne(shark); // 이동 끝난 상어
                Shark exist = next[moved.r][moved.c]; // 이미 그 칸에 있던 상어
                if (exist == null || exist.k < moved.k) {
                    next[moved.r][moved.c] = moved;
                }
            }
        }
        return next;
    }

    private static Shark moveOne(Shark shark) {
        int r = shark.r;
        int c = shark.c;
        int s = shark.s;
        int d = shark.d;
        int k = shark.k;

        if (d == UP || d == DOWN) {
            if (R == 1) {
                return new Shark(1, c, s, d, k);
            }

            int cycle = 2 * (R-1);
            int mv = s % cycle;

            for (int i = 0; i < mv; i++) {
                if (d == UP) {
                    if (r == 1) {
                        d = DOWN;
                        r++;
                    } else r--;
                } else {
                    if (r == R) {
                        d = UP;
                        r--;
                    } else r++;
                }
            }
        } else { // 오른쪽 / 왼쪽
            if (C == 1) {
                return new Shark(r, 1, s, d, k);
            }

            int cycle = 2 * (C-1);
            int mv = s % cycle;

            for (int i = 0; i < mv; i++) {
                if (d == LEFT) {
                    if (c == 1) {
                        d = RIGHT;
                        c++;
                    } else c--;
                } else {
                    if (c == C) {
                        d = LEFT;
                        c--;
                    } else c++;
                }
            }
        }

        return new Shark(r, c, s, d, k);
    }
}