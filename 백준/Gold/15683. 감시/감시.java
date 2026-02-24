import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static ArrayList<CCTV> cctvs = new ArrayList<CCTV>();
    static int answer = Integer.MAX_VALUE;

    // 상, 우, 하, 좌 (시계방향)
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static class CCTV {
        int x, y, type;
        CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    // CCTV 타입별 가능한 방향 조합
    static final int[][][] DIRS = {
            {}, // 0번
            { {0}, {1}, {2}, {3} },                 // 1번: 4방향 중 1개
            { {0,2}, {1,3} },                       // 2번: 마주보는 2방향 (2가지)
            { {0,1}, {1,2}, {2,3}, {3,0} },         // 3번: 직각 (4가지)
            { {0,1,2}, {1,2,3}, {2,3,0}, {3,0,1} }, // 4번: 3방향 (4가지)
            { {0,1,2,3} }                           // 5번: 4방향 (1가지)
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                int v = map[i][j];
                if (v >= 1 && v <= 5) {
                    cctvs.add(new CCTV(i, j, v));
                }
            }
        }

        dfs(0, map);
        System.out.println(answer);
    }

    static void dfs (int idx, int[][] cur) {
        if (idx == cctvs.size()) {
            answer = Math.min(answer, countBlind(cur));
            return;
        }

        CCTV cctv = cctvs.get(idx);
        int type = cctv.type;

        for (int[] dirs : DIRS[type]) {
            int[][] next = copy(cur);
            for (int d : dirs) {
                watch(next, cctv.x, cctv.y, d);
            }

            dfs(idx + 1, next);
        }
    }

    static void watch(int[][] b, int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (0 <= nx && nx < N && 0 <= ny && ny < M) {
            if (b[nx][ny] == 6) break;       // 벽
            if (b[nx][ny] == 0) b[nx][ny] = -1; // 빈칸이면 감시표시

            nx += dx[dir];
            ny += dy[dir];
        }
    }

    static int countBlind(int[][] b) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (b[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }

    static int[][] copy(int[][] src) {
        int[][] dst = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(src[i], 0, dst[i], 0, M);
        }

        return dst;
    }
}