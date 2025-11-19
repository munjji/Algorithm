import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new LinkedList<>();
        
        // ["코드 번호(code)", "제조일(date)", "최대 수량(maximum)", "현재 수량(remain)"]
        int extIdx = getIndex(ext);
        int sortIdx = getIndex(sort_by);
                
        for (int[] d : data) {
            if (d[extIdx] < val_ext) {
                list.add(d);
            }
        }

        list.sort(Comparator.comparingInt(o -> o[sortIdx]));

        int[][] answer = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
    
    private int getIndex(String key) {
        switch (key) {
            case "code":     return 0;
            case "date":     return 1;
            case "maximum":  return 2;
            case "remain":   return 3;
        }
        return -1;
    }
}