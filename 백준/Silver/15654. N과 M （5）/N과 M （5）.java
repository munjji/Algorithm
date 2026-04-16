import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());

       arr = new int[N];
       result = new int[M];
       visited = new boolean[N];
       st = new StringTokenizer(br.readLine());
       for (int i = 0; i < N; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
       }

       Arrays.sort(arr);

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
            result[depth] = arr[i];
            dfs(depth + 1);
            visited[i] = false;
        }

    }
}