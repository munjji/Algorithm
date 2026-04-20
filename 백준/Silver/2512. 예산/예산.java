import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] budgets = new int[N];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budgets[i]);
        }

        int M = Integer.parseInt(br.readLine());

        int left = 0;
        int right = max;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long sum = 0;
            for (int b : budgets) {
                sum += Math.min(b, mid);
            }

            if (sum <= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(answer);
    }
}