import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        // 사용했던 단어들 저장하기
        HashSet<String> usedWords = new HashSet<>();

        usedWords.add(words[0]);

        for (int i = 1; i < words.length; i++) { 
            String prevWord = words[i - 1];  
            String currWord = words[i];      

            // 이전 단어 끝 글자랑 현재 단어 첫 글자랑 일치하는지 확인 or 사용했던 단어들 중복 사용하는 지 확인
            if (prevWord.charAt(prevWord.length() - 1) != currWord.charAt(0) || usedWords.contains(currWord)) {
                answer[0] = (i % n) + 1; 
                answer[1] = (i / n) + 1;
                break;
            }

            usedWords.add(currWord);
        }

        return answer;
    }
}