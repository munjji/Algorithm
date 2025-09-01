import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        char[] target = String.join("", spell).toCharArray();
        Arrays.sort(target);
        String targetStr = new String(target);
        
        for (String word: dic) {
            char[] c_word = word.toCharArray();
            Arrays.sort(c_word);
            String c_word_str = new String(c_word);
            
            if (c_word_str.equals(targetStr)) return 1;
        }
        
        return 2;
    }
}