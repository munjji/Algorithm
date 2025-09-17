class Solution {
    public int solution(int chicken) {
        int answer = 0;
        
        while (chicken >= 10) {
            int service = chicken / 10;   // 쿠폰으로 바꿀 수 있는 치킨 수
            int rest = chicken % 10;      // 남은 쿠폰
            answer += service;            // 서비스 치킨 더하기
            chicken = service + rest;     // 새로 얻은 치킨(=쿠폰) + 남은 쿠폰
        }
                
        return answer;
    }
}