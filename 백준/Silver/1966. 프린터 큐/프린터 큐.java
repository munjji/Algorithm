import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                q.offer(new int[]{j, Integer.parseInt(st.nextToken())});
            }

            int answer = 0;
            int order = 0;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int index = cur[0];
                int priority = cur[1];

                boolean hasHigher = false;
                for (int[] doc : q) {
                    if (doc[1] > priority) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) q.offer(cur);
                else {
                    order++;
                    if (index == M) {
                        answer = order;
                        break;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}