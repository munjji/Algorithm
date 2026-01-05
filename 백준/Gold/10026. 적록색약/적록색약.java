import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] map;
    static char[][] rgbMap;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int origin, rgb = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        rgbMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                rgbMap[i][j] = (c == 'G') ? 'R' : c;
            }
        }

        // 일반인
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 'R') bfs(i, j, 'R', map);
                    else if (map[i][j] == 'G') bfs(i, j, 'G', map);
                    else bfs(i, j, 'B', map);
                    origin++;
                }
            }
        }

        // 적록색약
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (rgbMap[i][j] == 'R') bfs(i, j, 'R', rgbMap);
                    else bfs(i, j, 'B', rgbMap);
                    rgb++;
                }
            }
        }

        System.out.println(origin + " " + rgb);
    }

    static void bfs(int i, int j, char target, char[][] targetMap) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (targetMap[nx][ny] != target) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

}