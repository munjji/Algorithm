import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] arr;
    static int[] pick = new int[6];
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line == null) break;

            StringTokenizer st = new StringTokenizer(line);
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            out.append('\n');
        }

        System.out.print(out.toString());
    }

    static void dfs(int depth, int start) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                out.append(pick[i]);
                if (i < 5) out.append(' ');
            }
            out.append('\n');
            return;
        }

        for (int i = start; i < k; i++) {
            pick[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }
}