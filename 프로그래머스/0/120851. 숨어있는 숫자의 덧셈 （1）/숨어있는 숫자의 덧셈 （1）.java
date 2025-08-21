class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String onlyDigits = my_string.replaceAll("[a-zA-Z]", "");
        for (char digit: onlyDigits.toCharArray()) {
            answer += digit - '0';
        }
        return answer;
    }
}