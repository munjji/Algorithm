import java.io.*;
import java.util.*;

public class Main {

    static int F, S, G, U, D;
    static int[] ds;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 건물 층수
        S = Integer.parseInt(st.nextToken()); // 현재 위치 층
        G = Integer.parseInt(st.nextToken()); // 스타트링크 위치 층
        U = Integer.parseInt(st.nextToken()); // 위로 얼만큼 이동
        D = Integer.parseInt(st.nextToken()); // 아래로 얼만큼 이동

        visited = new boolean[F + 1];
        ds = new int[2];
        ds[0] = U;
        ds[1] = -D;

        int answer = bfs();
        System.out.println(answer != -1 ? answer : "use the stairs");
    }

    static private int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {S, 0});

        while (!q.isEmpty()) {
            int[] qq = q.poll();
            int cur = qq[0];
            int cnt = qq[1];

            if (cur == G) {
                return cnt;
            }

            for (int i = 0; i < 2; i++) {
                int next = cur + ds[i];

                if (next <= 0 || next > F) continue;
                if (visited[next]) continue;
                q.add(new int[] {next, cnt + 1});
                visited[next] = true;
            }
        }

        return -1;
    }
}