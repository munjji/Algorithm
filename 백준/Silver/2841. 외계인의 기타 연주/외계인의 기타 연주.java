import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int answer = 0;

        // 손가락 움직임
        // => 손가락으로 프렛을 한 번 누르거나 떼는 것

        Stack<Integer>[] stack = new Stack[7];
        for (int i = 1; i <= 6; i++) {
            stack[i] = new Stack<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int fret = Integer.parseInt(st.nextToken());

            while (!stack[line].isEmpty() && stack[line].peek() > fret) {
                stack[line].pop();
                answer++;
            }

            if (!stack[line].isEmpty() && stack[line].peek() == fret) continue;

            stack[line].push(fret);
            answer++;
        }

        System.out.print(answer);
    }
}