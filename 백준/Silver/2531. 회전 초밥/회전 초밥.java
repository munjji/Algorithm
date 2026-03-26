import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 회전 초밥 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] cnt = new int[d + 1];
        int kind = 0;

        for (int i = 0; i < k; i++) {
            if (cnt[sushi[i]] == 0) kind++;
            cnt[sushi[i]]++;
        }

        int answer = kind + (cnt[c] == 0 ? 1 : 0);

        for (int i = 1; i < N; i++) {
            int remove = sushi[i - 1];
            cnt[remove]--;
            if (cnt[remove] == 0) kind--;

            int add = sushi[(i + k - 1) % N];
            if (cnt[add] == 0) kind++;
            cnt[add]++;

            int current = kind + (cnt[c] == 0 ? 1 : 0);
            answer = Math.max(answer, current);
        }

        System.out.println(answer);
    }
}