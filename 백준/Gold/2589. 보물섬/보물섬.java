import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] dist;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(cnt);
    }

    static private void bfs (int x, int y) {
        dist = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        dist[x][y] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M ) continue;
                if (map[nx][ny] == 'L' && dist[nx][ny] == 0)  {
                    q.add(new int[]{nx, ny});
                    dist[nx][ny] = dist[curX][curY] + 1;
                    cnt = Math.max(cnt, dist[nx][ny] - 1);
                }
            }
        }
    }
}