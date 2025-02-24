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
        String string = st.nextToken();

        for (int i = 97; i < 123; i++) {
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j) == i) {
                    bw.write(j + "");
                    break;
                }

                if (j == string.length() - 1) {
                    bw.write(-1 + "");
                }
            }
            bw.write(" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}