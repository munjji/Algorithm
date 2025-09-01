class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int width = (int)board[0] / 2;
        int height = (int)board[1] / 2;
        
        for (String key: keyinput) {
            if (key.equals("left")) answer[0] -= 1;
            else if (key.equals("right")) answer[0] += 1;
            else if (key.equals("up")) answer[1] += 1;
            else answer[1] -= 1;
            
            if (answer[0] > width) answer[0] = width;
            else if (answer[0] < -width) answer[0] = -width;
            
            if (answer[1] > height) answer[1] = height;
            else if (answer[1] < -height) answer[1] = -height;
        }
        
        return answer;
    }
}