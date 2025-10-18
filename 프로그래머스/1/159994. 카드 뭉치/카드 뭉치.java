import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i = 0, j = 0; // cards1, cards2 포인터

        for (String word : goal) {
            if (i < cards1.length && word.equals(cards1[i])) {
                i++;
            } else if (j < cards2.length && word.equals(cards2[j])) {
                j++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}