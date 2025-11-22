import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            String S = sc.next();      
            int K = sc.nextInt();      
            
            long total = 0L;
            
            for (int i = 0; i < K; i++) {
                long x = sc.nextLong();
                total += x;
            }
                        
            String answer = rotate(S, total);
            System.out.println(answer);
        }
	}
	
	static String rotate(String S, long X) {
	    int len = S.length();
	    if (len == 0) return S;

	    int shift = (int) ((X % len + len) % len);
        
        if (shift == 0) return S;
       
        return S.substring(shift) + S.substring(0, shift);
	}
}