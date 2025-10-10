import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 2];
        for (int i = N; i >= 1; i--) {
            int skip = dp[i + 1];
            int take = 0;
            if (i + T[i] <= N + 1) {
                take = P[i] + dp[i + T[i]];
            }
            dp[i] = Math.max(skip, take);
        }

        System.out.println(dp[1]);
    }
}