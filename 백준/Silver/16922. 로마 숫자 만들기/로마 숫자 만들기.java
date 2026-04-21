import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[] romes = {'I', 'V', 'X', 'L'};
    static char[] result;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        result = new char[N];
        dfs(0, 0);

        System.out.print(set.size());
    }

    static private void dfs(int depth, int start) {
        if (depth == N) {
            int sum = 0;
            for (char c : result) {
                if (c == 'I') sum += 1;
                else if (c == 'V') sum += 5;
                else if (c == 'X') sum += 10;
                else sum += 50;
            }
            set.add(sum);
            return;
        }

        for (int i = start; i < 4; i++) {
            result[depth] = romes[i];
            dfs(depth + 1, i);
        }
    }
}