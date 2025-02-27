import java.util.*;

import java.io.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;            

        for (int x = 0; x <= d; x = x + k) {
            long b = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
            
            answer = answer + (long) b / k
                +1;
        }
        return answer;
    }
}