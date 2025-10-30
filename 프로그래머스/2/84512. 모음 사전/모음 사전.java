class Solution {
    static char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
    static int cnt = 0;
    static int answer = 0;
    static boolean found = false;
    
    public int solution(String word) {
        dfs("", word);
        return answer;
    }
    
    static void dfs(String cur, String target) {
        if (found) return;
        
        if (!cur.isEmpty()) {
            cnt++;
        }
        
        if (cur.equals(target)) {
            answer = cnt;
            found = true;
            return;
        }
        
        if (cur.length() == 5) return;
        
        for (char c: alphabet) {
            dfs(cur + c, target);
        }
    }
}