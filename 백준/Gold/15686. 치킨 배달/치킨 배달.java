import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int[] selected;
    static int minAnswer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    homes.add(new int[]{i, j});
                } else if (val == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        selected = new int[M];
        comb(0, 0);
        System.out.println(minAnswer);
    }

    static void comb (int depth, int start) {
        if (depth == M) {
            calcChickenDist();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[depth] = i;
            comb(depth + 1, i + 1);
        }
    }

    static void calcChickenDist() {
        int sum = 0;

        for (int[] home : homes) {
            int hx = home[0];
            int hy = home[1];

            int distMin = Integer.MAX_VALUE;

            for (int i = 0; i < M; i++) {
                int cIdx = selected[i];
                int[] chicken = chickens.get(cIdx);
                int cx = chicken[0];
                int cy = chicken[1];

                int dist = Math.abs(hx - cx) + Math.abs(hy - cy);
                distMin = Math.min(dist, distMin);
            }

            sum += distMin;
        }

        minAnswer = Math.min(minAnswer, sum);
    }
}