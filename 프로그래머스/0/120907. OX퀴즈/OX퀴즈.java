class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0 ; i < quiz.length; i++) {
            String[] q = quiz[i].split(" ");
            int ans = 0;
            int num1 = Integer.parseInt(q[0]);
            int num2 = Integer.parseInt(q[2]);
            if (q[1].equals("+")) ans = num1 + num2;
            else ans = num1 - num2;
            
            if (ans == Integer.valueOf(q[4])) answer[i] = "O";
            else answer[i] = "X";
        }
        
        return answer;
    }
}