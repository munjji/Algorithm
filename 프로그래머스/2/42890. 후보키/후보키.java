import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int row = relation.length;
        int col = relation[0].length;
        
        List<Integer> candidateKeys = new ArrayList<>();
        
        for (int bit = 1; bit < (1 << col); bit++) {
            // 최소성 검사
            boolean minimal = true;
            for (int key : candidateKeys) {
                if ((key & bit) == key) {
                    minimal = false;
                    break;
                }
            }
            
            if (!minimal) continue;
            
            // 유일성 검사
            Set<String> set = new HashSet<>();
            for (int r = 0; r < row; r++) {
                StringBuilder sb = new StringBuilder();
                
                for (int c = 0; c < col; c++) {
                    if ((bit & (1 << c)) != 0) {
                        sb.append(relation[r][c] + "|");
                    }
                }
                
                set.add(sb.toString());
            }
            
            if (set.size() == row) {
                candidateKeys.add(bit);
            }
        }
        
        return candidateKeys.size();
    }
}