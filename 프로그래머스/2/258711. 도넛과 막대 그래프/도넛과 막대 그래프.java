import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {        
        // 생성한 정점 찾기 (in degree = 0 && out degree >= 2)
        // 정점의 out degree = 그래프 수
        // in degree = 1이고 out degree가 0인 개수 찾기 -> 막대그래프 개수
        // in degree >= 2인 개수 찾기-> 8자 그래프 개수
        int max = 0;
        Arrays.sort(edges, (a, b) -> a[0] - b[0]);
        for (int[] e: edges) {
            max = Math.max(max, Math.max(e[0], e[1]));
        }
        
        int[] in = new int[max + 1];
        int[] out = new int[max + 1];
        
        for (int[] e: edges) {
            out[e[0]]++;
            in[e[1]]++;
        }
        
        // 새로운 정점 찾기 
        int start = -1;
        for (int i = 1; i <= max; i++) {
            if (in[i] == 0 && out[i] >= 2) {
                start = i;
                break;
            }
        }
        
        // 그래프 총 개수 찾기
        int graph_cnt = out[start];
        
        // 막대, 팔자, 도넛 그래프 개수 찾기
        int stick = 0;
        int eight = 0;
        int donut = 0;
        for (int i = 1; i <= max; i++) {
            if (i == start) continue;
            
            // 막대그래프 개수 찾기
            //in degree = 1이고 out degree가 0인 개수 찾기
            if (in[i] >= 1 && out[i] == 0) stick++;
            
            // 8자그래프 개수 찾기
            // in degree >= 2 && out degree >= 2인 개수 찾기-> 8자 그래프 개수
            if (in[i] >= 2 && out[i] >= 2) eight++;
        }
        
        donut = graph_cnt - stick - eight;
        
        return new int[]{start, donut, stick, eight};
    }
}