import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[100001];
        int left = 0;
        int answer = 0;

        for (int right = 0; right < N; right++) {
            cnt[nums[right]]++;

            while (cnt[nums[right]] > K) {
                cnt[nums[left]]--;
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }

        System.out.println(answer);

    }
}