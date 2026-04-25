import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static List<CCTV> cctvs = new ArrayList<CCTV>();
    static int answer = Integer.MAX_VALUE;

    // 상, 우, 하, 좌
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static private class CCTV {
        int x, y, type;

        CCTV (int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    // 상 하 좌 우 (0 1 2 3)
    static final int[][][] DIRS = {
            {},                                     // 0번: 아무것도 아님
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
                int type = map[i][j];
                if (type >= 1 && type <= 5) {
                    cctvs.add(new CCTV(i, j, type));
                }
            }
        }

        dfs(0, map);
        System.out.print(answer);
    }

    static void dfs(int idx, int[][] cur) {
        if (idx == cctvs.size()) {
            answer = Math.min(answer, countBlind(cur));
            return;
        }

        CCTV cctv = cctvs.get(idx);
        int type = cctv.type;

        for (int[] dir : DIRS[type]) {
            int[][] next = copy(cur);

            for (int d : dir) {
                watch(cctv.x, cctv.y, d, next);
            }

            dfs(idx + 1, next);
        }
    }

    static void watch (int x, int y, int dir, int[][] next) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (nx >= 0 && ny >= 0 && nx < N && ny < M) {
            if (next[nx][ny] == 6) break;
            if (next[nx][ny] == 0) {
                next[nx][ny] = -1;
            }

            nx += dx[dir];
            ny += dy[dir];
        }
    }

    static int countBlind(int[][] next) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (next[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }

    static int[][] copy (int[][] next) {
        int[][] dst = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dst[i][j] = next[i][j];
            }
        }

        return dst;
    }

}