class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int currentNum = num;
        
        int currentRow = (currentNum - 1) / w;
        
        answer = 1;

        while (true) {
            int nextRow = currentRow + 1;
            int nextUpperNum = -1;

            int totalRows = (n + w - 1) / w;

            if (nextRow >= totalRows) {
                break;
            }

            int col_idx_in_current_row = -1;

            if (currentRow % 2 == 0) {
                col_idx_in_current_row = (currentNum - 1) % w;
            } else {
                col_idx_in_current_row = (w - 1) - (currentNum - (currentRow * w + 1));
            }

            if (nextRow % 2 == 0) {
                nextUpperNum = (nextRow * w) + 1 + col_idx_in_current_row;
            } else {
                nextUpperNum = ((nextRow + 1) * w) - col_idx_in_current_row;
            }

            if (nextUpperNum > n) {
                break;
            }
            
            answer++;
            currentNum = nextUpperNum;
            currentRow = nextRow;
        }

        return answer;
    }
}