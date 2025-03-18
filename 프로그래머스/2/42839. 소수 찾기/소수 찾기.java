import java.util.*;

class Solution {
    static Set<Integer> primes = new HashSet<>();
    
    public int solution(String numbers) {
        char[] numArray = numbers.toCharArray();
        boolean[] used = new boolean[numArray.length];

        generateNumbers(numArray, "", used);
        
        return countPrimes(primes);
    }
    
    // 모든 숫자 조합 생성 (백트래킹)
    private void generateNumbers(char[] numArray, String current, boolean[] used) {
        if (!current.isEmpty()) {
            primes.add(Integer.parseInt(current)); // 숫자로 변환하여 Set에 추가
        }

        for (int i = 0; i < numArray.length; i++) {
            if (!used[i]) {
                used[i] = true;
                generateNumbers(numArray, current + numArray[i], used);
                used[i] = false;
            }
        }
    }
    
    // 소수 판별
    private int countPrimes(Set<Integer> numbers) {
        int count = 0;
        for (int num : numbers) {
            if (isPrime(num)) count++;
        }
        return count;
    }

    // 소수 판별 함수
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}