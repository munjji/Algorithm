import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static char[] sign;
    static boolean[] used = new boolean[10];
    static String answer;
    static boolean found;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        sign = new char[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        found = false;
        Arrays.fill(used, false);
        answer = "";
        dfsMax(new StringBuilder(), -1, 0);
        String maxStr = answer;

        found = false;
        Arrays.fill(used, false);
        answer = "";
        dfsMin(new StringBuilder(), -1, 0);
        String minStr = answer;

        System.out.println(maxStr);
        System.out.println(minStr);
    }

    static void dfsMax(StringBuilder cur, int prev, int depth) {
        if (found) return;
        if (depth == k + 1) {
            answer = cur.toString();
            found = true;
            return;
        }

        for (int d = 9; d >= 0; d--) {
            if (used[d]) continue;
            if (depth > 0 && !ok(sign[depth - 1], prev, d)) continue;

            used[d] = true;
            cur.append(d);
            dfsMax(cur, d, depth + 1);
            cur.deleteCharAt(cur.length() - 1);
            used[d] = false;
        }
    }

    static void dfsMin(StringBuilder cur, int prev, int depth) {
        if (found) return;
        if (depth == k + 1) {
            answer = cur.toString();
            found = true;
            return;
        }

        for (int d = 0; d <= 9; d++) {
            if (used[d]) continue;
            if (depth > 0 && !ok(sign[depth - 1], prev, d)) continue;

            used[d] = true;
            cur.append(d);
            dfsMin(cur, d, depth + 1);
            cur.deleteCharAt(cur.length() - 1);
            used[d] = false;
        }
    }

    static boolean ok(char s, int a, int b) {
        if (s == '<') return a < b;
        return a > b;
    }

}