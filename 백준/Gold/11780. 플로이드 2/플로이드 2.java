import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] city = new int[n][n];
        int[][] next = new int[n][n];

        int INF = 1000000000;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) city[i][j] = 0;
                else city[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            
            if (city[x][y] > c) {
                city[x][y] = c;
                next[x][y] = y;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (city[i][j] > city[i][k] + city[k][j]) {
                        city[i][j] = city[i][k] + city[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // 최소 비용 출력하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (city[i][j] == INF) sb.append(0 + " ");
                else sb.append(city[i][j] + " ");
            }
            sb.append("\n");
        }

        // 경로 출력하기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == j || city[i][j] == INF) {
                    sb.append(0 + "\n");
                    continue;
                }

                List<Integer> path = new ArrayList<>();
                int cur = i;

                while (cur != j) {
                    path.add(cur);
                    cur = next[cur][j];
                }
                path.add(j);

                sb.append(path.size() + " ");
                for (int node : path) {
                    sb.append(node + 1 + " ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}