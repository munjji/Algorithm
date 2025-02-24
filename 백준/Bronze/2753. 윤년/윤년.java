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
        int year = Integer.parseInt(st.nextToken());

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            bw.write(1+ "");
        } else {
            bw.write(0+ "");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
