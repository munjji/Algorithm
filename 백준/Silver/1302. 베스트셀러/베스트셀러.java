import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (a, b) -> {
            if (!a.getValue().equals(b.getValue())) return b.getValue() - a.getValue();
            return a.getKey().compareTo(b.getKey());
        });

        System.out.print(list.get(0).getKey());
    }
}