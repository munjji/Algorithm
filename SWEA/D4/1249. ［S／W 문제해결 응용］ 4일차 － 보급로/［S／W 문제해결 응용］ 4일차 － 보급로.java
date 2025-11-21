import java.util.*;
import java.io.FileInputStream;

class Solution
{
    static int N;
    static int[][] grid;
    static int[][] dist;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		int[] sum = new int[T];
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
            grid = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = sc.next();
                for (int j = 0; j < N; j++) {
                    grid[i][j] = line.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            int answer = dijkstra();
            System.out.println("#" + test_case + " " + answer);
		}
	}
	
    private static int dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        dist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0}); // x, y, cost

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int cost = cur[2];

            if (cost > dist[x][y]) continue;
            if (x == N - 1 && y == N - 1) return cost;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                int ncost = cost + grid[nx][ny];
                if (ncost < dist[nx][ny]) {
                    dist[nx][ny] = ncost;
                    pq.offer(new int[]{nx, ny, ncost});
                }
            }
        }

        return dist[N - 1][N - 1];
    }
}