import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] oven = new int[D];
        int[] dough = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < D; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dough[i] = Integer.parseInt(st.nextToken());
        }

        // 오븐 전처리
        for (int i = 1; i < D; i++) {
            oven[i] = Math.min(oven[i], oven[i - 1]);
        }

        int pos = D - 1;

        for (int i = 0; i < N; i++) {
            pos = binarySearch(oven, dough[i], pos);
            if (pos == -1) {
                System.out.println(0);
                return;
            }
            pos--;
        }

        System.out.println(pos + 2);
    }

    static int binarySearch(int[] oven, int dough, int high) {
        int low = 0;
        int pos = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (oven[mid] >= dough) {
                pos = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return pos;
    }
}