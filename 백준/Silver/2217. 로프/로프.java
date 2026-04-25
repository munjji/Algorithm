import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] lope = new int[N];
        for (int i = 0; i < N; i++) {
            lope[i] = Integer.parseInt(br.readLine());
        }

        int w = 0;
        Arrays.sort(lope);

        for (int l : lope) {
            int weight = N * l;
            w = Math.max(w, weight);
            N--;
        }

        System.out.print(w);
    }
}