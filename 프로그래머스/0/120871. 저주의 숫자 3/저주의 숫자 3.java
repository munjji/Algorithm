class Solution {
    public int solution(int n) {
        int count = 0; // 실제값
        int num = 0; // 가공된 값

        while (count < n) {
            num++;
            if (num % 3 == 0 || String.valueOf(num).contains("3")) {
                continue;
            }
            count++;
        }

        return num;
    }
}