import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int row = Integer.parseInt(br.readLine());

            int[][] sticker = new int[2][row+1];
            int[][] dp = new int[2][row+1];
            for (int j = 0; j < 2; j++) {
                String[] inputs = br.readLine().split(" ");
                for (int k = 1; k <= row; k++) {
                    sticker[j][k] = Integer.parseInt(inputs[k-1]);
                }
            }

            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            for (int j = 2; j <= row; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + sticker[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + sticker[1][j];
            }

            System.out.println(Math.max(dp[0][row], dp[1][row]));
        }
    }
}