import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // key가 아이디, value가 닉네임인 HashMap
        HashMap<String, String> map = new HashMap<>();
        for (String r : record) {
            String[] splited = r.split(" ");
            if (splited[0].equals("Leave")) continue;
            
            String id = splited[1];
            String nickname = splited[2];
            
            map.put(id, nickname);
        }
        
        List<String> answer_list = new ArrayList<>();
        
        for (String r : record) {
            StringBuilder sb = new StringBuilder();
            String[] splited = r.split(" ");
            String status = splited[0];
            
            if (status.equals("Change")) continue;
            
            String id = splited[1];
            String nickname = map.get(id);
            
            String sb_status = (status.equals("Enter") ? "들어왔습니다." : "나갔습니다.");
            sb.append(nickname + "님이 " + sb_status);
            
            answer_list.add(sb.toString());
        }
        
        String[] answer = answer_list.toArray(new String[0]);
        
        return answer;
    }
}