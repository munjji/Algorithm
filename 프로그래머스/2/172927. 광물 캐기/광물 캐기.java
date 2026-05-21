import java.util.*;

class Solution {

    static class MineralGroup {
        int dia;
        int iron;
        int stone;

        MineralGroup(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        List<MineralGroup> groups = new ArrayList<>();

        int totalPick = picks[0] + picks[1] + picks[2];

        // 광물 5개씩 그룹화
        for (int i = 0; i < minerals.length; i += 5) {
            if (groups.size() == totalPick) break;

            int dia = 0;
            int iron = 0;
            int stone = 0;

            for (int j = i; j < i + 5 && j < minerals.length; j++) {
                String m = minerals[j];

                if (m.equals("diamond")) {
                    dia += 25;
                    iron += 5;
                    stone += 1;
                }
                else if (m.equals("iron")) {
                    dia += 5;
                    iron += 1;
                    stone += 1;
                }
                else {
                    dia += 1;
                    iron += 1;
                    stone += 1;
                }
            }

            groups.add(new MineralGroup(dia, iron, stone));
        }

        Collections.sort(groups, (a, b) -> b.dia - a.dia);

        // 좋은 곡괭이부터 사용
        for (MineralGroup g : groups) {

            // 다이아 곡괭이
            if (picks[0] > 0) {
                answer += g.stone;
                picks[0]--;
            }

            // 철 곡괭이
            else if (picks[1] > 0) {
                answer += g.iron;
                picks[1]--;
            }

            // 돌 곡괭이
            else {
                answer += g.dia;
                picks[2]--;
            }
        }

        return answer;
    }
}