import java.util.*;

class Solution {
    
    static HashSet<Integer> primes = new HashSet<>();
    static char[] numArray;
    static boolean[] visited;
    
    public int solution(String numbers) {
        numArray = numbers.toCharArray();
        visited = new boolean[numArray.length];

        generateNumbers("");
        
        return countPrimes(primes);
    }
    
    // 모든 숫자 조합 생성 (백트래킹 함수)
    private void generateNumbers(String current) {
        if (!current.equals("")) {
            primes.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numArray.length; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            generateNumbers(current + numArray[i]);
            visited[i] = false;
        }
    }
    
    // 소수 개수
    private int countPrimes(Set<Integer> numbers) {
        int count = 0;
        for (int num : numbers) {
            if (isPrime(num)) count++;
        }
        return count;
    }

    // 소수 판별
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}