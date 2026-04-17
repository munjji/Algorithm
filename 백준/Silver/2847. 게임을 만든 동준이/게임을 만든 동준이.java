import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] levels = new int[N];

        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;

        for (int i = N - 2; i >= 0; i--) {
            if (levels[i] >= levels[i + 1]) {
                int newScore = levels[i + 1] - 1;
                answer += levels[i] - newScore;
                levels[i] = newScore;
            }
        }

        System.out.print(answer);
    }
}