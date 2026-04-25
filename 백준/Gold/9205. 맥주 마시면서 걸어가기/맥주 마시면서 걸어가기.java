import java.io.*;
import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int[] home = new int[2];
            home[0] = Integer.parseInt(st.nextToken());
            home[1] = Integer.parseInt(st.nextToken());

            int[][] convinient = new int[n][2];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                convinient[j][0] = Integer.parseInt(st.nextToken());
                convinient[j][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] festival = new int[2];
            festival[0] = Integer.parseInt(st.nextToken());
            festival[1] = Integer.parseInt(st.nextToken());

            sb.append(bfs(home, festival, convinient) + "\n");
        }

        System.out.print(sb);
    }

    static String bfs (int[] home, int[] festival, int[][] convinient) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(home);

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (calcDist(cur, festival) <= 1000) {
                return "happy";
            }

            for (int c = 0; c < n; c++) {
                if (!visited[c] && calcDist(cur, convinient[c]) <= 1000) {
                    visited[c] = true;
                    q.offer(convinient[c]);
                }
            }
        }

        return "sad";
    }

    static int calcDist (int[] cur, int[] dest) {
        int diff_x = Math.abs(cur[0] - dest[0]);
        int diff_y = Math.abs(cur[1] - dest[1]);

        return diff_x + diff_y;
    }

}