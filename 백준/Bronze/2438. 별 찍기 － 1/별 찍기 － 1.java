import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < i+1; j++) {
                bw.write("*");
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}