import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        int[][] jewels = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 보석 무게
            int V = Integer.parseInt(st.nextToken()); // 보석 가격
            jewels[i][0] = M;
            jewels[i][1] = V;
        }

        Arrays.sort(jewels, (a, b) -> a[0] - b[0]);

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long sum = 0;
        int idx = 0;
        for (int bag : bags) {
            while (idx < N && jewels[idx][0] <= bag) {
                pq.offer(jewels[idx][1]);
                idx++;
            }
            
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        System.out.print(sum);
    }
}