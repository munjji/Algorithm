import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        Arrays.sort(mats);
        int n = park.length;
        int m = park[0].length;
        
        
        for (int s = mats.length - 1; s >= 0; s--) {
            int size = mats[s];
            
            for (int i = 0; i + size <= n; i++) {
                for (int j = 0; j + size <= m; j++) {
                    if (canPlace(park, size, i, j)) {
                        return size;
                    }
                }
            }
        }
        
        
        return -1;
    }
    
    static boolean canPlace(String[][] park, int size, int x, int y) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (!park[i][j].equals("-1")) return false;
            }
        }
        
        return true;
    }
}