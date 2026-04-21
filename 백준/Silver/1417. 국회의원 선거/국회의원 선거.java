import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N - 1; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        while (!pq.isEmpty() && dasom <= pq.peek()) {
            int top = pq.poll();
            top--;
            dasom++;
            cnt++;
            pq.offer(top);

        }
        System.out.print(cnt);
    }
}