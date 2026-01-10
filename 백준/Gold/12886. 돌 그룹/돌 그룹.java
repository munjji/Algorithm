import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[1501][1501];
        Queue<int[]> q = new LinkedList<>();

        int[] start = {A, B, C};
        Arrays.sort(start);
        visited[start[0]][start[1]] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int a = cur[0];
            int b = cur[1];
            int c = cur[2];

            if (a == b && b == c) {
                System.out.println(1);
                return;
            }

            int[][] pairs = {
                    {a, b, c},
                    {a, c, b},
                    {b, c, a}
            };

            for (int[] xy : pairs) {
                if (xy[0] == xy[1]) continue;

                int min = Math.min(xy[0], xy[1]);
                int max = Math.max(xy[0], xy[1]);

                int na = min * 2;
                int nb = max - min;
                int nc = xy[2];

                int[] narr = {na, nb, nc};
                Arrays.sort(narr);
                if (visited[narr[0]][narr[1]]) continue;
                visited[narr[0]][narr[1]] = true;
                q.add(new int[]{narr[0],narr[1],narr[2]});
            }
        }

        System.out.println(0);
    }

}