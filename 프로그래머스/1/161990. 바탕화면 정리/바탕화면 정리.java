import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        // 가장 왼쪽, 가장 오른쪽 찾기 + #가 있는 인덱스 중에 가장 작은 인덱스, 큰 인덱스 찾기
        int left = wallpaper[0].length();
        int right = 0;
        
        // 가장 왼쪽, 가장 오른쪽 찾기
        for (int i = 0; i < wallpaper.length; i++) {
            if (left > wallpaper[i].indexOf('#') && wallpaper[i].indexOf('#') != -1) {
                left = wallpaper[i].indexOf('#');
            }
            if (right < wallpaper[i].lastIndexOf('#') && wallpaper[i].lastIndexOf('#') != -1) {
                right = wallpaper[i].lastIndexOf('#');
            }
        }
        
        // #가 있는 인덱스 중에 가장 작은 인덱스, 큰 인덱스 찾기
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                list.add(i);
            }
        }
        Collections.sort(list);
        int top = list.get(0);
        int down = list.get(list.size() - 1);
        answer[0] = top;
        answer[1] = left;
        answer[2] = down + 1;
        answer[3] = right + 1;
        return answer;
    }
}