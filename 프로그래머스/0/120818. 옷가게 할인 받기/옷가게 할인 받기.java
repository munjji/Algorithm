class Solution {
    public int solution(int price) {
        int answer = 0;
        double rate = 1.0;
        
        if (price >= 500000) {
            rate = 0.2;
        } else if (price >= 300000 && price < 500000) {
            rate = 0.1;
        } else if (price >= 100000 && price < 300000) {
            rate = 0.05;
        } else {
            return price;
        }
        
        answer = price - (int)Math.round(price * rate);    
        
        return answer;
    }
}