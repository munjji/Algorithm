import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());

        int[] dp = new int[X + 1];
        int[] prev = new int[X + 1];

        dp[0] = 1;
        dp[1] = 0;

        for (int i = 2; i <= X; i++) {
            // 기본은 -1 연산
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;

            // 2로 나눌 수 있다면
            if (i % 2 == 0
                    && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2;
            }

            // 3으로 나눌 수 있다면
            if (i % 3 == 0
                    && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3;
            }
        }

        System.out.println(dp[X]);

        int cur = X;
        while (cur != 0) {
            System.out.print(cur + " ");
            cur = prev[cur];
        }
    }
}