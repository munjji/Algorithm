class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int temp = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            answer = lcm(temp, arr[i]);
            temp = answer;
        }
        
        return answer;
    }
    
    private int gcd (int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    private int lcm (int a, int b) {
        return a * b / gcd(a, b);
    }
}