import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int bridge = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandNum = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    bfs(i, j, islandNum);
                    islandNum++;
                }
            }
        }

        for (int num = 2; num < islandNum; num++) {
            makeBridge(num);
        }

        System.out.print(bridge);
    }

    static void bfs (int i, int j, int num) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;
        map[i][j] = num;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;

                map[nx][ny] = num;
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    static void makeBridge(int island) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[N][N];

        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == island) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                // 다른 섬 도착
                if (map[nx][ny] != 0 && map[nx][ny] != island) {
                    bridge = Math.min(bridge, dist[x][y]);
                    return;
                }

                if (map[nx][ny] == 0 && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}