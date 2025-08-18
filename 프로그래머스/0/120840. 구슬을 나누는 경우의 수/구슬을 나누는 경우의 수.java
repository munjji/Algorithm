import java.math.*;

class Solution {
    public int solution(int balls, int share) {
        return combination(balls, share).intValue(); 
    }
    
    private BigInteger combination(int n, int r) {
        if (r == 0 || n == r) return BigInteger.ONE;
        
        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;
        
        for (int i = 0; i < r; i++) {
            numerator = numerator.multiply(BigInteger.valueOf(n - i));
            denominator = denominator.multiply(BigInteger.valueOf(i + 1));
        }
        return numerator.divide(denominator);
    }
}