import java.io.*;
import java.util.*;

public class Main {

    static int[][] damage = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 9, 3},
            {1, 3, 9}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] SCV = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            SCV[i] = Integer.parseInt(st.nextToken());
        }

        int answer = bfs(SCV[0], SCV[1], SCV[2]);
        System.out.print(answer);
    }

    static private int bfs(int a, int b, int c) {
        boolean[][][] visited = new boolean[61][61][61];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{a, b, c, 0});
        visited[a][b][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int x = cur[0];
            int y = cur[1];
            int z = cur[2];
            int cnt = cur[3];

            if (x == 0 && y == 0 && z == 0) return cnt;

            for (int i = 0; i < 6; i++) {
                int nx = Math.max(0, x - damage[i][0]);
                int ny = Math.max(0, y - damage[i][1]);
                int nz = Math.max(0, z - damage[i][2]);

                if (!visited[nx][ny][nz]) {
                    visited[nx][ny][nz] = true;
                    q.offer(new int[]{nx, ny, nz, cnt + 1});
                }
            }
        }

        return 0;
    }
}