import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 연결되어 있는 컴퓨터 쌍의 수

        graph = new List[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        dfs(1);

        System.out.print(cnt);
    }

    static void dfs(int start) {
        visited[start] = true;

        for (int v : graph[start]) {
            if (!visited[v]) {
                cnt++;
                dfs(v);
            }
        }
    }
}