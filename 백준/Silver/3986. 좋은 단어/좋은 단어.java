import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (Character ch : line.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                } else stack.push(ch);
            }

            if (stack.isEmpty()) answer++;
        }

        System.out.print(answer);
    }
}