import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());

        long N = 0;
        long longSqrtS = (long) Math.sqrt(S * 2L);

        long[] x = {-1, 0, 1};
        for (int i = 0; i < 3; i++) {
            long n = longSqrtS + x[i];
            if (n * (n + 1) / 2 <= S) {
                N = n;
            }
        }

        System.out.print(N);
    }
}