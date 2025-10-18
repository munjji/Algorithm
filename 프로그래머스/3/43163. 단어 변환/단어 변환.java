import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }

        return answer;
    }
    
    public boolean canChange(String str1, String str2) {
        int dif_cnt = 0;
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                dif_cnt++;
            }
        }
        
        if (dif_cnt == 1) {
            return true;
        }
        
        return false;
    }
    
    public void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = Math.min(answer, cnt);
            return;
        }
        
        for (int i = 0; i < words.length; i++) { 
            if (!visited[i] && canChange(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, cnt+1);
                visited[i] = false;
            }
        }
    }
    
    
}