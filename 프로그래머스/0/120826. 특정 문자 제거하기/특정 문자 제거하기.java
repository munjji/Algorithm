class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (char c: my_string.toCharArray()) {
            if (c == letter.toCharArray()[0]) {
                continue;
            } else {
                sb.append(c);
            }
        }
        answer = sb.toString();
        return answer;
    }
}