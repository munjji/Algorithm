import java.util.*;

class Solution {
    public String solution(String letter) {
        StringBuilder sb = new StringBuilder();
        String[] letter_split = letter.split(" ");
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Map<String, Character> morse_map = new HashMap<>();
        for (int i = 0; i < morse.length; i++) {
            morse_map.put(morse[i], (char)(i + 97));
        }
        
        for (String split: letter_split) {
            sb.append(morse_map.get(split));
        }
        return sb.toString();
    }
}