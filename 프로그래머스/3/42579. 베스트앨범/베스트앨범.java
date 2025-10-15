import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genre_map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] i) -> -i[0])
                                                                .thenComparingInt(i -> -i[1])
                                                                .thenComparingInt(i -> i[2]));

        for (int i = 0; i < plays.length; i++) {
            genre_map.merge(genres[i], plays[i], Integer::sum);
        }
        
        for (int i = 0; i < plays.length; i++) {
            pq.add(new int[] {genre_map.get(genres[i]), plays[i], i});
        }
        
        List<Integer> answer = new ArrayList<>();
        
        while (!pq.isEmpty()) {
            int genre_total = pq.peek()[0];
            
            for (int i = 0; i < 2; i++) {
                if (pq.isEmpty() || pq.peek()[0] != genre_total) break;
                answer.add(pq.poll()[2]);
            }
            
            while (!pq.isEmpty() && pq.peek()[0] == genre_total) pq.poll();
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}