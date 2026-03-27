import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] nums;
    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        result = new int[M];

        for (int i = 1; i <= N; i++) {
            nums[i-1] = i;
        }

        dfs(0, 0);
    }

    static private void dfs(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            result[depth] = nums[i];
            dfs(depth+1, i + 1);
        }
    }
}