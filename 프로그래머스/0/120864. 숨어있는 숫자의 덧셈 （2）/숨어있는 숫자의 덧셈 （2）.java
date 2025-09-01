class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] parts = my_string.split("[^0-9]+");
        
        for (String part: parts) {
            if (!part.isEmpty()) answer += Integer.parseInt(part);
        }
        
        return answer;
    }
}