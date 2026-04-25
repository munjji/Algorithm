import java.io.*;
import java.util.*;

public class Main {

    static int N, M; // M 치킨집 개수
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> homes = new ArrayList<>();
    static int[] selected;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int info = Integer.parseInt(st.nextToken());
                if (info == 1) {
                    homes.add(new int[]{i, j});
                } else if (info == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        selected = new int[M];
        dfs(0, 0);
        System.out.print(answer);
    }

    static void dfs(int depth, int start) {
        if (depth == M) {
            calcChickenDist();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            selected[depth] = i;
            dfs(depth + 1, i + 1);
        }
    }

    static void calcChickenDist() {
        int sum = 0;

        for (int[] home : homes) {
            int home_x = home[0];
            int home_y = home[1];

            int distMin = Integer.MAX_VALUE;

            for (int idx : selected) {
                int[] chicken = chickens.get(idx);
                int chicken_x = chicken[0];
                int chicken_y = chicken[1];

                int diff_x = Math.abs(home_x - chicken_x);
                int diff_y = Math.abs(home_y - chicken_y);
                int diff = diff_x + diff_y;

                distMin = Math.min(distMin, diff);
            }
            sum += distMin;
        }

        answer = Math.min(answer, sum);
    }
}