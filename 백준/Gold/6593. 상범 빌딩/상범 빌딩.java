import java.io.*;
import java.util.*;

public class Main {

    static int L, R, C;
    static char[][][] building;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            building = new char[L][R][C];
            visited = new boolean[L][R][C];

            int[] start = new int[3]; // z, x, y
            int[] exit = new int[3];

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    line = br.readLine();

                    if (line.isEmpty()) {
                        r--;
                        continue;
                    }

                    for (int c = 0; c < C; c++) {
                        char ch = line.charAt(c);
                        if (ch == 'S') {
                            start[0] = l;
                            start[1] = r;
                            start[2] = c;
                        }
                        if (ch == 'E') {
                            exit[0] = l;
                            exit[1] = r;
                            exit[2] = c;
                        }
                        building[l][r][c] = ch;
                    }
                }
            }

            int dist = bfs(start, exit);
            if (dist == -1) System.out.println("Trapped!");
            else System.out.println("Escaped in " + dist + " minute(s).");
        }

    }

    static int bfs(int[] start, int[] exit) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start[0], start[1], start[2], 0}); // z, x, y, dist
        visited[start[0]][start[1]][start[2]] = true; // z, x, y

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0];
            int x = cur[1];
            int y = cur[2];
            int dist = cur[3];

            if (z == exit[0] && x == exit[1] && y == exit[2]) {
                return dist;
            }

            for (int d = 0; d < 6; d++) {
                int newZ = z + dz[d];
                int newX = x + dx[d];
                int newY = y + dy[d];

                if (newZ < 0 || newX < 0 || newY < 0 || newZ >= L || newX >= R || newY >= C) continue;
                if (visited[newZ][newX][newY]) continue;
                if (building[newZ][newX][newY] == '#') continue;

                visited[newZ][newX][newY] = true;
                q.offer(new int[] {newZ, newX, newY, dist + 1});
            }
        }

        return -1;
    }
}