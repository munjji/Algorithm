import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 일자 수

        int[] T = new int[N + 2];
        int[] P = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 2]; // i일째부터 퇴사 전까지 벌 수 있는 최대 금액

        for (int i = N; i >= 1; i--) {
            int skip = dp[i + 1]; // 상담 안 하고 넘어가기
            int take = 0;         // 상담 함

            if (i + T[i] <= N + 1) {
                take = P[i] + dp[i + T[i]]; // 오늘 상담해서 돈 P[i] 받고, 상담 끝난 다음 날부터 다시 최대 벌 수 있는 금액 더하기
            }

            dp[i] = Math.max(skip, take); // 큰 값 선택해서 저장
        }

        System.out.print(dp[1]);
    }
}