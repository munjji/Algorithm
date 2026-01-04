import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
        }

        int INF = Integer.MAX_VALUE;
        int[] dp = new int[N];
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            if (dp[i] == INF) continue;

            for (int jump = 1; jump <= arr[i]; jump++) {
                int next = i + jump;

                if (next >= N) break;
                dp[next] = Math.min(dp[next], dp[i] + 1);
            }
        }

        if (dp[N-1] == INF) System.out.println(-1);
        else System.out.println(dp[N-1]);
    }
}