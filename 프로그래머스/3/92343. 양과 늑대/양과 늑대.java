import java.util.*;

class Solution {
    static int maxSheepCnt = 0;
    int[] gInfo;
    int[][] gEdges;
    
    // info: 양, 늑대 노드 정보, edges: 노드 연결 관계
    public int solution(int[] info, int[][] edges) {
        boolean[] visited = new boolean[info.length];
        gEdges = edges;
        gInfo = info;
        
        dfs (0, 0, 0, visited);
        
        return maxSheepCnt;
    }
    
    private void dfs (int idx, int sheep, int wolf, boolean[] visited) {
        visited[idx] = true;
        if (gInfo[idx] == 0) {
            sheep++;
            if (sheep > maxSheepCnt) {
                maxSheepCnt = sheep;
            }
        } else if (gInfo[idx] == 1) {
            wolf++;
        }
        
        if (sheep <= wolf) {
            return;
        }
        
        for (int[] edge: gEdges) {
            if (visited[edge[0]] && !visited[edge[1]]) {
                boolean[] newVisited = new boolean[gInfo.length];
                for (int i = 0; i < visited.length; i++) {
                    newVisited[i] = visited[i];
                }
                
                dfs(edge[1], sheep, wolf, newVisited);
            }
        }
    }
}

// DFS 탐색하면서 maxSheepCnt 세어주기
// 1. 다음 탐색하는 vertex가 양(0)인지, 늑대(1)인지 확인하기
//     양이면 SheepCnt 올리고, 현재 SheepCnt랑 maxSheepCnt랑 비교해서 더 크면 바꿔치기
//     늑대이면 WolfCnt 올리기
// 2. 현재 양의 개수 <= 늑대의 개수인 거 반드시 확인해줘야 함
//     조건 만족하면 그냥 return 해버려
// 3. 반복문 돌면서 dfs 탐색하기
//     현재 노드는 방문했고 방문할 노드는 방문하지 않은 조건을 만족하는 애들만 탐색
