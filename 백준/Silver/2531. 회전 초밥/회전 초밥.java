import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 총 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[N];

        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        int unique = 0;
        int max = 0;

        for (int i = 0; i < k; i++) {
            if (count[sushi[i]] == 0) unique++;
            count[sushi[i]]++;
        }

        max = unique + (count[c] == 0 ? 1 : 0);

        for (int left = 1; left < N; left++) {
            int right = (left + k - 1) % N;

            count[sushi[left - 1]]--;
            if (count[sushi[left - 1]] == 0) unique--;

            if (count[sushi[right]] == 0) unique++;
            count[sushi[right]]++;

            int sum = unique + (count[c] == 0 ? 1 : 0);
            max = Math.max(max, sum);
        }

        System.out.print(max);
    }
}