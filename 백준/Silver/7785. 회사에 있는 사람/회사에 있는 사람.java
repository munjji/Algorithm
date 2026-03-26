import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        HashMap<String, String> log = new HashMap<>();

        List<String> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();
            log.put(name, status);
        }

        for (Map.Entry<String, String> entry : log.entrySet()) {
            if (entry.getValue().equals("enter")) {
                names.add(entry.getKey());
            }
        }

        Collections.sort(names, Collections.reverseOrder());

        for (String name : names) {
            System.out.println(name);
        }
    }
}