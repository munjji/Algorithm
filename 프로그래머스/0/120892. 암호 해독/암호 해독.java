class Solution {
    public String solution(String cipher, int code) {
        StringBuilder sb = new StringBuilder();
        char[] c_cipher = cipher.toCharArray();
        int max_idx = cipher.length() / code;
        for (int i = 1; i <= max_idx; i++) {
            int idx = (i * code) - 1;
            sb.append(c_cipher[idx]);
        }
        return sb.toString();
    }
}