class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for (int i = 0; i < arr1.length; i++) {
            for (int k = 0; k < arr1[0].length; k++) {
                int a = arr1[i][k];
                if (a == 0) continue;
                for (int j = 0; j < arr2[0].length; j++) {
                    answer[i][j] += a * arr2[k][j];
                }
            }
        }
        
        return answer;
    }
}