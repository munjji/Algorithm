import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int shark = 2;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        int shark_x = -1, shark_y = -1;
        int time = 0;
        int eat = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 9) {
                    shark_x = i;
                    shark_y = j;
                }
            }
        }

        map[shark_x][shark_y] = 0;

        while (true) {
            int[][] dist = new int[N][N];
            for (int[] d : dist) Arrays.fill(d, -1);

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{shark_x, shark_y});
            dist[shark_x][shark_y] = 0;

            List<int[]> fishes = new ArrayList<>();

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int cx = cur[0], cy = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    if (dist[nx][ny] != -1) continue;
                    if (map[nx][ny] > shark) continue;

                    dist[nx][ny] = dist[cx][cy] + 1;
                    q.offer(new int[]{nx, ny});

                    if (map[nx][ny] != 0 && map[nx][ny] < shark) {
                        fishes.add(new int[]{nx, ny, dist[nx][ny]});
                    }
                }
            }

            if (fishes.isEmpty()) break;

            // 1. 거리 2. 위 3. 왼쪽
            Collections.sort(fishes, (a, b) -> {
                if (a[2] != b[2]) return a[2] - b[2];
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });

            int[] target = fishes.get(0);

            time += target[2];
            shark_x = target[0];
            shark_y = target[1];

            map[shark_x][shark_y] = 0;
            eat++;

            if (eat == shark) {
                eat = 0;
                shark++;
            }
        }

        System.out.print(time);
    }

    static private int countFish () {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 || shark <= map[i][j]) cnt++;
            }
        }

        return cnt;
    }
}