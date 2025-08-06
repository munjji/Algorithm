class Solution {
    // 최대공약수
    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    // 두 수가 더 이상 나눠지지 않도록 만드는 함수
    public static int[] reduce(int a, int b) {
        int g = gcd(a, b);
        return new int[] { a / g, b / g };
    }
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        int numer = 0;
        int denom = 0;
        
        if (denom1 == denom2) {
            numer = numer1 + numer2;
            denom = denom1;
        } else {
            numer = numer1 * denom2 + numer2 * denom1;
            denom = denom1 * denom2;
        }
        answer = reduce(numer, denom);

        return answer;
    }
}