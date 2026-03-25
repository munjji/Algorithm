import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] nums;
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        visited = new boolean[N];
        result = new int[M];

        for (int i = 1; i <= N; i++) {
            nums[i - 1] = i;
        }

        dfs(0);
    }

    static private void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            result[depth] = nums[i];
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}