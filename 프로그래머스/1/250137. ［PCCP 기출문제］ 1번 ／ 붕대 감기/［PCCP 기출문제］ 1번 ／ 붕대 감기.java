import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // bandage는 [시전 시간, 초당 회복량, 추가 회복량]
        int longtime = bandage[0];
        int recover_exp = bandage[1];
        int bonus_exp = bandage[2];
        
        int time = 0; // 진행 시간
        int exp = health; // 현재 체력
        int success_time = 0; // 연속 성공 시각
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int[] attack : attacks) {
            q.offer(new int[]{attack[0], attack[1]});
        }
        
        while (time < attacks[attacks.length-1][0] && exp > 0) {
            time++; // 1초 지남
            
            if (!q.isEmpty()) {
                int[] attack = q.peek();
                int attack_time = attack[0];
                int attack_exp = attack[1];
                if (attack_time == time) {
                    q.remove();
                    success_time = 0;
                    exp -= attack_exp;
                } else {
                    if (success_time + 1 == longtime) {
                        // 이번 초가 '연속 성공 마지막 초'일 때
                        success_time = 0;
                        exp += recover_exp;    // 기본 회복
                        exp += bonus_exp;      // 보너스 회복
                    } else {
                        success_time++;
                        exp += recover_exp;    // 기본 회복만
                    }

                    if (exp > health) exp = health;
                }
            
            }
            
            if (exp <= 0) return -1;
            
            System.out.println("현재 시간: " + time + " 현재 체력: " + exp + " 연속 성공: " + success_time);
        }
        
        return exp;
    }
}