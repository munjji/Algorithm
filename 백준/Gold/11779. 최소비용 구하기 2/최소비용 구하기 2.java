import java.io.*;
import java.util.*;

public class Main {

    static private class Node implements Comparable<Node> {
        int to;
        int cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int n, m;
    static List<Node>[] graph;
    static int[] dist;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end] + "\n");
        List<Integer> path = new ArrayList<>();
        int cur = end;
        while (cur != 0) {
            path.add(cur);
            cur = parent[cur];
        }

        Collections.reverse(path);
        sb.append(path.size() + "\n");
        for (int node : path) {
            sb.append(node + " ");
        }

        System.out.print(sb.toString());
    }

    private static void dijkstra(int start) {
        dist = new int[n + 1];
        parent = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[start] = 0;
        parent[start] = 0;
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (dist[cur.to] < cur.cost) continue;

            for (Node next : graph[cur.to]) {
                if (dist[cur.to] + next.cost < dist[next.to]) {
                    dist[next.to] = dist[cur.to] + next.cost;
                    parent[next.to] = cur.to;
                    q.add(new Node(next.to, dist[next.to]));
                }
            }
        }
    }
}