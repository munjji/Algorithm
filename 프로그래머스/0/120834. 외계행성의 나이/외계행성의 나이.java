class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        String sAge = String.valueOf(age);
        
        for (int i = 0 ; i < sAge.length(); i++) {
            int index = (sAge.charAt(i) - '0') + 97;
            sb.append((char)index);
        }
        return sb.toString();
    }
}