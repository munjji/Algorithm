import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer>[] graph;
    static int[] deg;         // 각 노드 차수
    static boolean[] isCycle; // 순환선인지 확인

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        deg = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
            deg[a]++;
            deg[b]++;
        }

        findCycleNodesByLeafRemoval();

        int[] dist = calcDistanceToCycle();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dist[i]).append(' ');
        }

        System.out.println(sb.toString().trim());
    }

    // 1. 사이클 노드를 찾자 (5, 6, 4 제거완료)
    static void findCycleNodesByLeafRemoval() {
        isCycle = new boolean[N + 1];
        Arrays.fill(isCycle, true);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (deg[i] == 1) q.offer(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            isCycle[cur] = false;

            for (int next : graph[cur]) {
                if (deg[next] == 0) continue;

                deg[next]--;
                deg[cur] = 0;

                if (deg[next] == 1) {
                    q.offer(next);
                }
            }
        }
    }

    // 2. 사이클에서 5, 6, 4와의 거리 찾자
    static int[] calcDistanceToCycle() {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (isCycle[i]) {
                dist[i] = 0;
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                q.offer(next);
            }
        }

        return dist;
    }

}