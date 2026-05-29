import java.util.*;

class Solution {
    
    static List<String> path = new ArrayList<>();
    static boolean[] used;

    public String[] solution(String[][] tickets) {
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
    
    static private boolean dfs(String current, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (used[i]) continue;
            if (tickets[i][0].equals(current)) {
                used[i] = true;
                path.add(tickets[i][1]);
                
                if (dfs(tickets[i][1], tickets, cnt + 1)) return true;
                
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
        
        return false;
    }
}