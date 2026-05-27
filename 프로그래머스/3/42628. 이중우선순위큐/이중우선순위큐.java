import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String op : operations) {
            String[] ops = op.split(" ");
            
            if (ops[0].equals("D") && maxPQ.isEmpty()) {
                continue;
            }
            
            if (ops[0].equals("I")) {
                int num = Integer.parseInt(ops[1]);
                minPQ.offer(num);
                maxPQ.offer(num);
            } else if (ops[0].equals("D") && ops[1].equals("1")) {
                int max = maxPQ.poll();
                minPQ.remove(max);
            } else {
                int min = minPQ.poll();
                maxPQ.remove(min);
            }
        }
        
        if(maxPQ.isEmpty()) return new int[] {0,0};
        else return new int[] {maxPQ.poll(), minPQ.poll()};
    }
}