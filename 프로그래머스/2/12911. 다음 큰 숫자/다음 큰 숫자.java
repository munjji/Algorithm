class Solution {
    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        int next = n + 1;

        while (Integer.bitCount(next) != cnt) {
            next++;
        }

        return next;
    }
}