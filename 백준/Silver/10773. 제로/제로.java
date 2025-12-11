import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number != 0) {
                stack.push(number);
            } else {
                stack.pop();
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            sum += stack.get(i);
        }

        System.out.println(sum);
    }
}