import java.util.Scanner;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

        int[] sum = new int[T];
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
        	for (int j = 0; j < 10; j++) {
        		int number = sc.nextInt();
        		if (number % 2 != 0) sum[test_case-1] += number;
        	}

		}
        
        for (int i = 1; i <= T; i++) {
        	System.out.println("#" + i + " " + sum[i-1]);
        }
	}
}