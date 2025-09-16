class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        // 일단 기약분수를 만들고, 분모가 2 or 5로 나눠지는 지 확인하기!
        int number = gcd(a, b);
        b /= number;
        
        while (b % 2 == 0) b /= 2;
        while (b % 5 == 0) b /= 5;

        // 분모가 1이면 유한소수
        return (b == 1) ? 1 : 2;
    }
    
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }   
}