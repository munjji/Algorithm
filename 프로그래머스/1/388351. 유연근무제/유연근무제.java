class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int count = schedules.length;
        int sat = 6 - startday;
        int sun = sat + 1;
        
        if (sat == -1) {
            sun = 0;
            sat = 6;
        }
    
        
        for (int i = 0; i < count; i++) {
            int cri_time = 0;
            
            int mid = (schedules[i] / 10) % 10;
            if (mid < 5) {
                cri_time = schedules[i] + 10;
            } else {
                cri_time = schedules[i] + 50;
            }
            
            boolean ok = true;
            
            for (int j = 0; j < 7; j++) {
                if (j == sat || j == sun) continue;

                if (timelogs[i][j] > cri_time) {
                    ok = false;
                    break;
                }
            }
            
            if (ok) answer++;
        }

        return answer;
    }
}