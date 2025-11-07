import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, String[]> car_type = new HashMap<>();
        TreeMap<String, Integer> car_fee = new TreeMap<>();
        
        int s_time = fees[0], s_fee = fees[1], u_time = fees[2], u_fee = fees[3];
        
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            String time = record[0];
            String car = record[1];
            String type = record[2];
            
            if (type.equals("IN")) {
                car_type.put(car, new String[]{time, type});
            } else { // OUT일 경우
                String[] time_type = new String[2];
                time_type = car_type.get(car);
                String[] in_time = time_type[0].split(":");
                int in_total = Integer.parseInt(in_time[0]) * 60 + Integer.parseInt(in_time[1]);
                
                String[] out_time = time.split(":");
                int out_total = Integer.parseInt(out_time[0]) * 60 + Integer.parseInt(out_time[1]);
                
                int total = out_total - in_total;
                
                car_type.put(car, new String[]{time, type});
                car_fee.put(car, car_fee.getOrDefault(car, 0) + total);
            }
        }
        
        for (Map.Entry<String, String[]> e : car_type.entrySet()) {
            String[] time_type = new String[2];
            time_type = e.getValue();
            if (time_type[1].equals("IN")) {
                String[] in_time = time_type[0].split(":");
                int in_total = Integer.parseInt(in_time[0]) * 60 + Integer.parseInt(in_time[1]);
                int out_total = 23 * 60 + 59;
                
                int total = out_total - in_total;
                car_fee.put(e.getKey(), car_fee.getOrDefault(e.getKey(), 0) + total);
            }
            
            car_fee.put(e.getKey(), car_fee.get(e.getKey()) > s_time
                ? (int)(s_fee + Math.ceil((car_fee.get(e.getKey()) - s_time) / (double) u_time) * u_fee)
                : s_fee
            );
        }
        
        int[] answer = new int[car_fee.size()];
        int idx = 0;
        for (Map.Entry<String, Integer> e : car_fee.entrySet()) {
            answer[idx] = e.getValue();
            idx++;
        }
        return answer;
    }
}