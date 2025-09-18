class Solution {
    public int solution(int M, int N) {
        int answer = 0;
        if (M == 1 && N == 1) return 0;
        // 2 -> 1, 3 -> 2, 4 -> 3
        answer += (M - 1) + (N - 1) * M;
        return answer;
    }
}