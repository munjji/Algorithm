class Solution {
    public int solution(int n) {
        return n / gcd(n, 6);
    }
    
    private int gcd (int a, int b) {
        while(b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}