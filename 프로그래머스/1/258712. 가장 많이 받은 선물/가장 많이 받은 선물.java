import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        
        Map<String, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(friends[i], i);
        }

        int[][] give = new int[n][n]; // A -> B에게 선물 준 수 
        int[] giftIndex = new int[n]; // 선물지수

        for (String g : gifts) {
            String[] split = g.split(" ");
            int a = idxMap.get(split[0]);
            int b = idxMap.get(split[1]);

            give[a][b]++;          // a가 b에게 선물을 1개 줌
            giftIndex[a]++;        // 준 선물 +1
            giftIndex[b]--;        // 받은 선물 -1
        }

        int[] nextMonth = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int giveI = give[i][j];
                int giveJ = give[j][i];

                if (giveI > giveJ) {
                    nextMonth[i]++;
                } else if (giveI < giveJ) {
                    nextMonth[j]++;
                } else { 
                    if (giftIndex[i] > giftIndex[j]) {
                        nextMonth[i]++;
                    } else if (giftIndex[i] < giftIndex[j]) {
                        nextMonth[j]++;
                    }
                }
            }
        }

        // 가장 많이 받은 선물 수 리턴
        int answer = 0;
        Arrays.sort(nextMonth);
        answer = nextMonth[n-1];

        return answer;
    }
}