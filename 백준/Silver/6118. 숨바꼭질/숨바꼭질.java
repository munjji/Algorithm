import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] dist = new int[N + 1];
        Arrays.fill (dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (dist[next] != -1) continue;

                dist[next] = dist[cur] + 1;
                q.offer(next);
            }
        }

        int maxDist = 0;

        for (int d : dist) {
            maxDist = Math.max(maxDist, d);
        }

        int node = 0;
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (dist[i] == maxDist) {
                if (node == 0) node = i;
                count++;
            }
        }

        System.out.print(node + " " + maxDist + " " + count);
    }
}