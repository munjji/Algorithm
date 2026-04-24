import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        HashMap<Character, Integer> weightMap = new HashMap<>(); // 알파벳별 가중치
        for (String word : words) {
            int ten = word.length() - 1;
            for (int i = 0; i < word.length(); i++) {
                int weight = (int) Math.pow(10, ten);
                weightMap.put(word.charAt(i), weightMap.getOrDefault(word.charAt(i), 0) + weight);
                ten--;
            }
        }

        // value 기준으로 내림차순 정렬
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(weightMap.entrySet());
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        HashMap<Character, Integer> alphabetMap = new HashMap<>(); // 알파벳별 숫자 배정

        int num = 9;
        for (Map.Entry<Character, Integer> e : list) {
            alphabetMap.put(e.getKey(), num);
            num--;
        }

        int sum = 0;
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(alphabetMap.get(word.charAt(i)));
            }
            sum += Integer.parseInt(sb.toString());
        }

        System.out.print(sum);
    }
}