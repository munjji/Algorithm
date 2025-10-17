import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] house = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            house[i][0] = Integer.parseInt(st.nextToken());
            house[i][1] = Integer.parseInt(st.nextToken());
            house[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][3];
        dp[1][0] = house[1][0];
        dp[1][1] = house[1][1];
        dp[1][2] = house[1][2];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = house[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = house[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = house[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}