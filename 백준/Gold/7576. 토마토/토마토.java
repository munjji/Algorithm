import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] grid = new int[N][M];
        int[][] day = new int[N][M];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                day[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    day[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
                if (grid[nx][ny] == -1) continue; // 토마토 없음
                if (day[nx][ny] != -1) continue; // 이미 방문해서 익어졌음
                if (grid[nx][ny] == 0) { // 방문 안 한 안 익은 토마토면 익히기
                    day[nx][ny] = day[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0 && day[i][j] == -1) { // 안 익은 토마토 있을 경우
                    System.out.println(-1);
                    return;
                }

                if (day[i][j] > answer) answer = day[i][j];
            }
        }

        System.out.println(answer);
    }
}