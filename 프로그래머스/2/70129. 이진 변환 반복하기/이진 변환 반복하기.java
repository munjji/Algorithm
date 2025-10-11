class Solution {
    public int[] solution(String s) {
        int cCnt = 0;
        int zCnt = 0;
        
        while (!s.equals("1")) {
            zCnt += s.chars().filter(c -> c == '0').count();
            s = s.replace("0", "");
            cCnt++;
            s = Integer.toBinaryString(s.length());
        }
        
        return new int[]{cCnt, zCnt};
    }
}