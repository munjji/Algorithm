import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] nums;
    static int[] result;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        result = new int[M];
        sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            nums[i - 1] = i;
        }

        dfs(0, 1);
        System.out.print(sb.toString());
    }

    static private void dfs (int depth, int start) {
        if (depth == M) {
            for (int r : result) {
                sb.append(r + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            result[depth] = i;
            dfs(depth + 1, i);
        }
    }
}