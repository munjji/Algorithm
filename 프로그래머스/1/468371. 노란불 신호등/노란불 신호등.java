class Solution {
    public int solution(int[][] signals) {
        int n = signals.length;
        
        int lcm = 1;
        int[] cycle = new int[n];
        
        for (int i = 0; i < n; i++) {
            int g = signals[i][0];
            int y = signals[i][1];
            int r = signals[i][2];
            
            cycle[i] = g + y + r;
            lcm = lcm(lcm, cycle[i]);
        }
        
        for (int t = 1; t <= lcm; t++) {
            boolean allYellow = true;
            
            for (int i = 0; i < n; i++) {
                int g = signals[i][0];
                int y = signals[i][1];
                
                int pos = (t-1) % cycle[i];
                if (!(g <= pos && pos < g + y)) {
                    allYellow = false;
                    break;
                }
            }
            
            if (allYellow) return t;
        }
        
        return -1;
    }
    
    // 최대 공약수
    private int gcd (int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // 최소 공배수
    private int lcm (int a, int b) {
        return a * b / gcd(a, b);
    }
}