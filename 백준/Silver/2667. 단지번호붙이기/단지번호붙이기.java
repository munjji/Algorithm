import java.awt.List;
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static boolean[][] visited;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < n; j++) {
                int c = line.charAt(j) - '0';
                board[i][j] = c;
            }
        }

        int dCnt = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && (board[i][j] == 1)) {
                    list.add(bfs(i, j));
                    dCnt++;
                }
            }
        }

        list.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        sb.append(dCnt).append("\n");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) sb.append(list.get(i));
            else sb.append(list.get(i)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = true;
        int width = 1;
        q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                width++;
                q.offer(new int[]{nx, ny});
            }
        }
        return width;
    }
}