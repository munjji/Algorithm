import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int[] nums = new int[10];

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            int val = c - '0';
            nums[val]++;
        }

        int answer = 0;
        int sum69 = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) {
                sum69 += nums[i];
                answer = Math.max(answer, sum69 % 2 == 0 ? sum69 / 2 : (sum69 / 2) + 1);
            } else {
                answer = Math.max(nums[i], answer);
            }
        }

        System.out.print(answer);
    }
}