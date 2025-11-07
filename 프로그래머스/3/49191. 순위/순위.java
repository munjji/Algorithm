class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] win = new boolean[n+1][n+1];
        
        for (int[] result: results) {
            int a = result[0];
            int b = result[1];
            win[a][b] = true;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            int known = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (win[i][j] || win[j][i]) known++;
            }
            
            if (known == n - 1) answer++;
        }
        
        return answer;
    }
}