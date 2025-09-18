class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        if (common[2] - common[1] == common[1] - common[0]) {
            int d = common[1] - common[0];
            answer = common[common.length - 1] + d;
        } else {
            int r = common[1] / common[0];
            answer = common[common.length - 1] * r;
        }
        return answer;
    }
}