import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int time = bfs(K, N);

        System.out.println(time);
    }

    public static int bfs(int K, int current) {
        boolean[] visited = new boolean[MAX + 1];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{current, 0});
        visited[current] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int nx = cur[0];
            int time = cur[1];

            if (nx == K) return time;

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    nx = cur[0] - 1;
                } else if (i == 1) {
                    nx = cur[0] + 1;
                } else {
                    nx = cur[0] * 2;
                }

                if (nx < 0 || nx > MAX) continue;
                if (visited[nx]) continue;
                visited[nx] = true;
                q.offer(new int[]{nx, time + 1});

            }
        }

        return -1;
    }
}