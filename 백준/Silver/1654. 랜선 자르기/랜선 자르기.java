//- 랜선의 길이를 이분 탐색으로 찾기
//- left = 1, right = 제일 큰 값
//- mid 줄여가면서 count 세기, count는 무조건 N보다 커야함 만약, 작으면 right 위치를 mid-1로 바꾸기

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] k_arr = new int[k];
        for (int i = 0; i < k; i++) {
            k_arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(k_arr);

        long left = 1;
        long right = (long) k_arr[k-1];
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (getCnt(k_arr, mid) < N) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }

        bw.write(String.valueOf(answer));

        bw.flush();
        br.close();
        bw.close();
    }

    static Long getCnt (int[] arr, long mid) {
        long cnt = 0;
         for (int i = 0; i < arr.length; i++) {
             cnt += arr[i] / mid;
         }
        return cnt;
    }
}