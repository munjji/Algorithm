import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] nums;
    static int[] op = new int[4]; // +, -, *, /
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }

     static void dfs(int idx, int num) {
        if (idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        int next = nums[idx];

        if (op[0] > 0) {
            op[0]--;
            dfs(idx + 1, num + next);
            op[0]++;
        }

        if (op[1] > 0) {
            op[1]--;
            dfs(idx + 1, num - next);
            op[1]++;
        }

        if (op[2] > 0) {
            op[2]--;
            dfs(idx + 1, num * next);
            op[2]++;
        }

        if (op[3] > 0) {
            op[3]--;
            dfs(idx + 1, divide(num, next));
            op[3]++;
        }
    }

    static int divide (int a, int b) {
        if (a < 0) {
            return -(Math.abs(a) / b);
        }
        return a / b;
    }
}