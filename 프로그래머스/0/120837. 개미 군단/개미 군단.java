class Solution {
    public int solution(int hp) {
        int answer = 0;
        int[] ant = {5, 3, 1};
        int rest = hp;
        for (int i = 0; i < 3; i++) {
            answer += rest / ant[i];
            rest = rest % ant[i];
        }
        return answer;
    }
}