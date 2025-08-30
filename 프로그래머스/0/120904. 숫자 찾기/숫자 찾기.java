class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String str_num = String.valueOf(num);
        
        answer = str_num.indexOf(String.valueOf(k)) != -1 ? str_num.indexOf(String.valueOf(k)) + 1 : -1;
        return answer;
    }
}