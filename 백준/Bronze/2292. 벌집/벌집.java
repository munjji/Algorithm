import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int layer = 1;
        int maxValue = 1;

        while (maxValue < n) {
            maxValue += 6 * layer;
            layer++;
        }

        System.out.println(layer);
    }
}