import java.util.*;

class Solution {
    static ArrayList<Integer>[] lists;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        lists = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            
            lists[start].add(end);
            lists[end].add(start);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            
            lists[start].remove(Integer.valueOf(end));
            lists[end].remove(Integer.valueOf(start));
            
            int start_cnt = bfs(start, n);
            int end_cnt = bfs(end, n);
            
            answer = Math.min(answer, Math.abs(start_cnt - end_cnt));
            
            lists[start].add(end);
            lists[end].add(start);
        }

        return answer;
    }
    
    private int bfs (int start, int n) {
        int cnt = 0;
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for (int i = 0; i < lists[now].size(); i++) {
                int next = lists[now].get(i);
                if (visited[next]) continue;
                cnt++;
                visited[next] = true;
                q.offer(next);
            }
        }
        
        return cnt;
    }
}