class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        
        // 각 문자마다 위아래 최소 이동 횟수 계산
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            int move = Math.min(c - 'A', 26 - (c - 'A'));
            answer += move;
        }
        
        // 좌우 이동 최소값 계산
        int move = len - 1;
        
        for (int i = 0; i < len; i++) {
            int next = i + 1;
            
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            
            move = Math.min(move, i + len - next + Math.min(i, len - next));
        }
        
        return answer + move;
    }
}