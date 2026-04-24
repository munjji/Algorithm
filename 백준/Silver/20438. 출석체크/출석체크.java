// 누적합 문제
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 총 학생 수
        int K = Integer.parseInt(st.nextToken()); // 졸고 있는 학생 수
        int Q = Integer.parseInt(st.nextToken()); // 출석 코드 보낼 학생 수
        int M = Integer.parseInt(st.nextToken()); // 주어질 구간의 수

        boolean[] sleeping = new boolean[N + 3]; // 0번 버리기 (1, 2번 배정 안 돼)
        boolean[] code = new boolean[N + 3]; // 0번 버리기 (1, 2번 배정 안 돼)

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            sleeping[Integer.parseInt(st.nextToken())] = true;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 줄고 있고, 코드도 받은 애 빼
            if (sleeping[num]) continue;
            for (int j = num; j <= N + 2; j += num) {
                if (!sleeping[j]) code[j] = true;
            }
        }

        int[] prefix = new int[N + 3];
        for (int i = 3; i <= N + 2; i++) {
            prefix[i] = prefix[i - 1];
            if (!code[i]) prefix[i]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // 1 ~ end 수 - 1 ~ (start - 1) 수
            sb.append(prefix[end] - prefix[start - 1]).append('\n');
        }

        System.out.print(sb);
    }
}