import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = plays.length;
        Map<String, Integer> genre_map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] i) -> -i[0])
                                                                .thenComparingInt(i -> -i[1])
                                                                .thenComparingInt(i -> i[2]));

        for (int i = 0; i < n; i++) {
            genre_map.put(genres[i], genre_map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        for (int i = 0; i < n; i++) {
            pq.add(new int[] {genre_map.get(genres[i]), plays[i], i});
        }
        
        List<Integer> answer = new ArrayList<>();
        
        while (!pq.isEmpty()) {
            int genre_total = pq.peek()[0];
            
            // 장르 별 두 개씩만 모으기
            for (int i = 0; i < 2; i++) {
                if (pq.isEmpty() || pq.peek()[0] != genre_total) break;
                answer.add(pq.poll()[2]);
            }
            
            // 세 개부턴 없애기
            while (!pq.isEmpty() && pq.peek()[0] == genre_total) pq.poll();
        }
        
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}