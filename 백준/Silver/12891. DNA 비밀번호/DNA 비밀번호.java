import java.io.*;
import java.util.*;

public class Main {

    static int[] need = new int[4];
    static int[] now = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String DNA = br.readLine();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            need[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 윈도우 [0, P - 1]
        for (int i = 0; i < P; i++) {
            add(DNA.charAt(i));
        }

        int cnt = 0;
        if (check()) cnt++;

        for (int i = P; i < S; i++) {
            add(DNA.charAt(i));
            remove(DNA.charAt(i - P));

            if (check()) cnt++;
        }

        System.out.print(cnt);
    }

    static void add(char c) {
        if (c == 'A') now[0]++;
        else if (c == 'C') now[1]++;
        else if (c == 'G') now[2]++;
        else if (c == 'T') now[3]++;
    }

    static void remove(char c) {
        if (c == 'A') now[0]--;
        else if (c == 'C') now[1]--;
        else if (c == 'G') now[2]--;
        else if (c == 'T') now[3]--;
    }

    static boolean check() {
        return now[0] >= need[0]
                && now[1] >= need[1]
                && now[2] >= need[2]
                && now[3] >= need[3];
    }
}