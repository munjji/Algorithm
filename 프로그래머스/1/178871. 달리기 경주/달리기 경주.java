import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        
        for (String name : callings) {
            int cur = map.get(name);
            if (cur == 0) continue;
            
            String front = players[cur - 1];
            
            players[cur - 1] = name;
            players[cur] = front;
            
            map.put(name, cur - 1);
            map.put(front, cur);
        }
        
        return players;
    }
}