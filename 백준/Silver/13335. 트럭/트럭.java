import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        int sec = 0;
        int cur_weight = 0;
        int idx = 0;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            q.add(0);
        }

        while (!q.isEmpty()) {
            sec++;
            cur_weight -= q.poll();

            if (idx < n) {
                int next_weight = trucks[idx];

                if (cur_weight + next_weight <= L) {
                    q.add(next_weight);
                    cur_weight += next_weight;
                    idx++;
                } else {
                    q.add(0);
                }
            }
        }

        System.out.println(sec);
    }
}