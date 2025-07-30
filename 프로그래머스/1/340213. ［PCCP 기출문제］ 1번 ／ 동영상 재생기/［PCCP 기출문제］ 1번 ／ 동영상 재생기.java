class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = toSeconds(video_len);
        int position = toSeconds(pos);
        int opStart = toSeconds(op_start);
        int opEnd = toSeconds(op_end);

        if (position >= opStart && position <= opEnd) {
               position = opEnd;
        }
        
        for (String command : commands) {
            int second = position % 60;
            
            if (command.equals("next")) {
                position += 10;
            } else if (command.equals("prev")) {
                position -= 10;
            }

            if (position > videoLen) {
                position = videoLen;
            }

            if (position < 0) {
                position = 0; 
            }
                    if (position >= opStart && position <= opEnd) {
               position = opEnd;
        }
            
            System.out.println(toMMSS(position));
        }
        

        return toMMSS(position);
    }
    
    private int toSeconds(String timeStr) {
        String[] parts = timeStr.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private String toMMSS(int seconds) {
        int min = seconds / 60;
        int sec = seconds % 60;
        return String.format("%02d:%02d", min, sec);
    }
}