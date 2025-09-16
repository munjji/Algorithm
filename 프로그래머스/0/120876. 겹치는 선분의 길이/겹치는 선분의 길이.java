import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int[] cover = new int[201];

        for (int[] line : lines) {
            int a = line[0];
            int b = line[1];

            for (int x = a; x < b; x++) {
                cover[x + 100]++;
            }
        }

        int ans = 0;
        for (int c : cover) {
            if (c >= 2) ans++; // 두 개 이상 겹치는 단위 구간만 합산
        }
        return ans;
    }
}