// DFS

import java.util.*;

class Solution {
    static int day = 0;
    static int X = 0;
    static int Y = 0;
    public int[] solution(String[] maps) {
        // X -> 위아래 (row), Y -> 좌우 (col)
        X = maps.length;
        Y = maps[0].length();
        int[][] map = new int[X][Y];
        
        // map에 저장
        for (int i = 0; i < X; i++) {
            char[] mapRow = maps[i].toCharArray();
            for (int j = 0; j < Y; j++) {
                if (mapRow[j] == 'X') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = mapRow[j] - '0';
                }
            }
        }
        
        List<Integer> days = new ArrayList<>();
        boolean[][] visited = new boolean[X][Y];
        
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    day = 0;
                    dfs(i, j, map, visited);
                    days.add(day);
                }
            }
        }
        
        if (days.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(days);
        
        return days.stream().mapToInt(i->i).toArray();
    }
    
    private void dfs (int x, int y, int[][] map, boolean[][] visited) {
        day += map[x][y];
        visited[x][y] = true;
        
        // 상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            
            if (newX < 0 || newY < 0 || newX >= X || newY >= Y) {
                continue;
            }
            
            if (!visited[newX][newY] && map[newX][newY] != 0) {
                dfs(newX, newY, map, visited);
            }
        }
        
    }
    
}