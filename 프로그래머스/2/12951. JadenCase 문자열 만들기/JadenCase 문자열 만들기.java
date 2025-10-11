class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ", -1);
        
        for (int i = 0; i < words.length; i++) {
            String word = "";
            if (!words[i].isEmpty()) {
                String firstLetter = words[i].substring(0, 1).toUpperCase();
                String remainLetter = words[i].substring(1).toLowerCase();
                word = firstLetter + remainLetter;
            }
            
            if (i == words.length - 1) sb.append(word);
            else sb.append(word + " ");
        }
        
        return sb.toString();
    }
}