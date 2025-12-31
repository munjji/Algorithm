import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        cnt = 0;

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs (0, 0);
        if (S == 0) cnt--;
        System.out.print(cnt);
    }

    static void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum == S) cnt++;
            return;
        }

        // 현재 원소를 선택하는 경우
        dfs(idx + 1, sum + arr[idx]);

        // 현재 원소를 선택하지 않는 경우
        dfs(idx + 1, sum);
    }
}