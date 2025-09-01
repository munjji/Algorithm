class Solution {
    public String solution(String polynomial) {
        int[] sum = new int[2];
        String[] terms = polynomial.split(" \\+ ");
        
        for (String term : terms) {
            if (term.contains("x")) {
                if (term.equals("x")) sum[0] += 1;
                else sum[0] += Integer.parseInt(term.replace("x", ""));
            } else {
                sum[1] += Integer.parseInt(term);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if (sum[0] == 0) {
            sb.append(sum[1]);
        } else if (sum[1] == 0) {
            sb.append(sum[0] == 1? "" : sum[0]); sb.append("x");
        } else {
            sb.append(sum[0] == 1? "" : sum[0]); sb.append("x"); sb.append(" + "); sb.append(sum[1]); 
        }
    
        return sb.toString();
    }
}