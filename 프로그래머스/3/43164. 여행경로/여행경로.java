import java.util.*;

class Solution {
    List<String> path = new ArrayList<>();
    boolean[] used;

    public String[] solution(String[][] tickets) {
        // 항공권 수만큼의 방문 여부 배열
        used = new boolean[tickets.length];

        // 사전 순 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });

        path.add("ICN");
        dfs("ICN", tickets, 0);

        // 리스트를 배열로 변환해 반환
        return path.toArray(new String[0]);
    }

    private boolean dfs(String current, String[][] tickets, int count) {
        // 모든 티켓 사용 완료
        if (count == tickets.length) return true;

        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                path.add(tickets[i][1]);

                if (dfs(tickets[i][1], tickets, count + 1)) return true;

                // 백트래킹
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }

        return false;
    }
}