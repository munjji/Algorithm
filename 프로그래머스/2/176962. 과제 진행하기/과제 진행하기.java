import java.util.*;

class Solution {
    
    class Work {
        String name;
        int start;
        int playtime;
        
        Work (String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        List<Work> works = new ArrayList<>();
        Stack<Work> stop = new Stack<>();
        
        for (String[] plan : plans) {
            String name = plan[0];
            int start = toMinute(plan[1]);
            int playtime = Integer.parseInt(plan[2]);
            works.add(new Work(name, start, playtime));
        }
        
        works.sort((a, b) -> a.start - b.start);
        
        int idx = 0;
        
        for (int i = 0; i < works.size() - 1; i++) {
            Work cur = works.get(i);
            Work next = works.get(i + 1);
            
            int availableTime = next.start - cur.start;
            
            if (cur.playtime <= availableTime) {
                answer[idx++] = cur.name;
                int remainTime = availableTime - cur.playtime;
                
                while (!stop.isEmpty() && remainTime > 0) {
                    Work stopped = stop.pop();
                    
                    if (stopped.playtime <= remainTime) {
                        remainTime -= stopped.playtime;
                        answer[idx++] = stopped.name;
                    } else {
                        stopped.playtime -= remainTime;
                        stop.push(stopped);
                        remainTime = 0;
                    }
                }
            } else {
                cur.playtime -= availableTime;
                stop.push(cur);
            }
        }
        
        answer[idx++] = works.get(works.size() - 1).name;
        
        while (!stop.isEmpty()) {
            answer[idx++] = stop.pop().name;
        }
        
        return answer;
    }
    
    private int toMinute(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }
}