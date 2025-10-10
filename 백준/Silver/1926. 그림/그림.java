import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int pictureCnt = 0;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    pictureCnt++;
                    int area = bfs(i, j);
                    if (area > maxArea) maxArea = area;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pictureCnt).append('\n').append(maxArea);
        System.out.println(sb.toString());
    }

    static int bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        int area = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                area++;
            }
        }

        return area;
    }
}