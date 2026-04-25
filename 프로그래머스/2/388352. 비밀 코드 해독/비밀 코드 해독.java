class Solution {
    
    static int answer = 0;
    static int[] selected = new int[5];
    
    public int solution(int n, int[][] q, int[] ans) {
        dfs(0, 1, n, q, ans);
        return answer;
    }
    
    static void dfs(int depth, int start, int n, int[][] q, int[] ans) {
        if (depth == 5) {
            boolean isValid = isValid(q, ans);
            if (isValid) answer++;
            return;
        }
        
        for (int i = start; i <= n; i++) {
            selected[depth] = i;
            dfs(depth + 1, i + 1, n, q, ans);
        }
    }
    
    static boolean isValid(int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            
            for (int s : selected) {
                for (int x : q[i]) {
                    if (s == x) {
                        cnt++;
                        break;
                    }
                }
            }
            
            if (cnt != ans[i]) {
                return false;
            }
        }
        
        return true;
    } 
}