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
        int row = Integer.parseInt(st.nextToken());

        String[] array = new String[row];

        for (int i = 0; i < row; i++) {
            array[i] = br.readLine();
        }

        for (int i = 0; i < row; i++) {
            String[] line_array = array[i].split(" ");
            int repeat = Integer.parseInt(line_array[0]);
            String line_string = line_array[1];

            for (int j = 0; j < line_string.length(); j++) {
                for (int k = 0; k < repeat; k++) {
                    bw.write(line_string.charAt(j));
                }
            }
            
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}