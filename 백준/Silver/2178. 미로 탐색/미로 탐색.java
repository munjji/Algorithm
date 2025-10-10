import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] miro;
    static int[][] dist;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        miro = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < m; j++) {
                miro[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        dist[i][j] = 1;
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            if (x == n - 1 && y == m - 1) return dist[x][y]; // 도착

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (miro[nx][ny] == 0) continue;
                if (dist[nx][ny] != 0) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        return -1;
    }
}