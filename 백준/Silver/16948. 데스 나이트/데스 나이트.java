import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        board = new int[N+1][N+1];

        st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int cnt = bfs (r1, c1, r2, c2);
        System.out.println(cnt);
    }

    private static int bfs (int r1, int c1, int r2, int c2) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N+1][N+1];
        q.add(new int[]{r1, c1, 0});
        visited[r1][c1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int count = cur[2];

            for (int d = 0; d < 6; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx == r2 && ny == c2) return count + 1;

                if (nx <= 0 || ny <= 0 || nx > N || ny > N) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, count + 1});
            }
        }

        return -1;
    }
}