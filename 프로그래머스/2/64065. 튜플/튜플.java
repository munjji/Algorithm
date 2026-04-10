import java.util.*;

class Solution {
    public int[] solution(String s) {    
        // "{{2},{2,1},{2,1,3},{2,1,3,4}}"
        s = s.substring(2, s.length() - 2);
        // "2},{2,1},{2,1,3},{2,1,3,4"
        String[] parts = s.split("\\},\\{");
        
        // 집합 크기 정렬
        HashSet<Integer> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        for (String part : parts) {
            String[] nums = part.split(",");
            List<Integer> nums_list = new ArrayList<>();
            
            for (String num : nums) {
                nums_list.add(Integer.parseInt(num));
            }
            list.add(nums_list);
        } 
        
        Collections.sort(list, (a, b) -> a.size() - b.size());
        
        List<Integer> result = new ArrayList<>();
        for (List<Integer> l : list) {
            for (int num : l) {
                if (!set.contains(num)) {
                    set.add(num);
                    result.add(num);
                }
            }
        }
        
        int[] answer = new int[result.size()];
        answer = result.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}