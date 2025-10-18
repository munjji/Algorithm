import java.util.*;

class Solution {
    public String solution(String phone_number) {
        int lastIndex = phone_number.length() - 4;
        String lastString = phone_number.substring(lastIndex);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lastIndex; i++) sb.append("*");
        sb.append(lastString);
        return sb.toString();
    }
}