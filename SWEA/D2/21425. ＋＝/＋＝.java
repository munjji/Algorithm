import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int x, y, N;
			x = sc.nextInt();
            y = sc.nextInt();
            N = sc.nextInt();
            
            int cnt = 0;
            while (x <= N && y <= N) {
            	if (x < y) {
            		x += y;
            	} else {
            		y += x;
            	}
            	cnt++;
            }
            
            System.out.println(cnt);
		}
	}
}