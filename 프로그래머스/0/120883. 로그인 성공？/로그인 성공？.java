import java.util.*;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        
        for (String[] user: db) {
            if (Arrays.equals(user, id_pw)) {
                answer = "login";
                break;
            }
            else if (user[0].equals(id_pw[0])) {
                answer = "wrong pw";
                 break;
            }
            else answer = "fail";
        }
        
        return answer;
    }
}