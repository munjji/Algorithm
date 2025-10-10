import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] normal;
    static char[][] blind;
    static boolean[][] visited;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        normal = new char[n][n];
        blind  = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);
                normal[i][j] = c;
                blind[i][j] = (c == 'G') ? 'R' : c;
            }
        }

        // 일반 시야
        visited = new boolean[n][n];
        int normalCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, normal);
                    normalCount++;
                }
            }
        }

        // 적록색약 시야
        visited = new boolean[n][n];
        int blindCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, blind);
                    blindCount++;
                }
            }
        }

        System.out.println(normalCount + " " + blindCount);
    }

    static void bfs(int i, int j, char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        char color = grid[i][j];
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny]) continue;

                if (grid[nx][ny] != color) continue;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}