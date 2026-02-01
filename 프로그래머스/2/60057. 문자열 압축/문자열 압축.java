class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        if (n == 1) return 1;
        
        answer = n;
        
        for (int step = 1; step <= n / 2; step++) {
            StringBuilder sb = new StringBuilder();
            
            String prev = s.substring(0, step);
            int count = 1;
            
            for (int j = step; j < n; j += step) {
                int end = Math.min(j + step, n);
                String cur = s.substring(j, end);
                
                if (cur.equals(prev)) {
                    count++;
                } else {
                    if (count > 1) sb.append(count);
                    sb.append(prev);
                    
                    prev = cur;
                    count = 1;
                }
            }
            
            if (count > 1) sb.append(count);
            sb.append(prev);
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}