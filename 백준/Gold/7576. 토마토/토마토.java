import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static int[][] map;
    static int[][] day;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        day = new int[N][M];

        // 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토 X
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                day[i][j] = -1;
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    day[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int sx = cx + dx[d];
                int sy = cy + dy[d];

                if (sx < 0 || sy < 0 || sx >= N || sy >= M) continue;
                if (map[sx][sy] == -1) continue;
                if (day[sx][sy] != -1) continue;
                if (map[sx][sy] == 0) {
                    q.offer(new int[]{sx, sy});
                    map[sx][sy] = 1;
                    day[sx][sy] = day[cx][cy] + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && day[i][j] == -1) {
                    System.out.print(-1);
                    return;
                }

                if (day[i][j] > answer) {
                    answer = day[i][j];
                }
            }
        }

        System.out.print(answer);
    }
}