import java.io.*;
import java.util.*;

public class Main {

    static char[][] board;
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = line.charAt(j-1);
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (bfs (i, j)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }

    static boolean bfs(int si, int sj) {
        boolean[][] visited = new boolean[N+1][M+1];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si, sj, 0, 0});
        visited[si][sj] = true;

        char ch = board[si][sj];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], px = cur[2], py = cur[3];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx <= 0 || ny <= 0 || nx > N || ny > M) continue;
                if (board[nx][ny] != ch) continue;
                if (nx == px && ny == py) continue;
                if (visited[nx][ny]) return true;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, x, y});
            }
        }
        return false;
    }
}