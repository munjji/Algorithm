class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long long_p = Long.parseLong(p);
        
        for (int i = 0; i <= t.length() - p.length(); i++) {
            String split_t = t.substring(i, i + p.length());
            long long_split_t = Long.parseLong(split_t);
                        
            if (long_p >= long_split_t) {
                answer++;
            }
        }

        return answer;
    }
}