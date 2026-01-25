import java.io.*;
import java.util.*;

public class Main {
    
    static int R, C;
    static char[][] grid;
    static int[][] fireTime;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        fireTime = new int[R][C];
        visited = new boolean[R][C];

        Queue<int[]> fireQ = new LinkedList<>();
        Queue<int[]> jihunQ = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j);
                fireTime[i][j] = -1;

                if (grid[i][j] == 'F') {
                    fireQ.offer(new int[]{i, j});
                    fireTime[i][j] = 0;
                }
                if (grid[i][j] == 'J') {
                    jihunQ.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        // 불 BFS
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (grid[nx][ny] == '#') continue;
                if (fireTime[nx][ny] != -1) continue;

                fireTime[nx][ny] = fireTime[x][y] + 1;
                fireQ.offer(new int[]{nx, ny});
            }
        }

        // 지훈 BFS
        while (!jihunQ.isEmpty()) {
            int[] cur = jihunQ.poll();
            int x = cur[0], y = cur[1], time = cur[2];

            if (x == 0 || y == 0 || x == R - 1 || y == C - 1) {
                System.out.println(time + 1);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (visited[nx][ny]) continue;
                if (grid[nx][ny] == '#') continue;
                if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= time + 1) continue;

                visited[nx][ny] = true;
                jihunQ.offer(new int[]{nx, ny, time + 1});
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}