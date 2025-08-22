class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder sb = new StringBuilder(my_string);
        char num1_char = sb.charAt(num1);
        char num2_char = sb.charAt(num2);
        sb.setCharAt(num1, num2_char);
        sb.setCharAt(num2, num1_char);
       
        return sb.toString();
    }
}