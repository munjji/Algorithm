import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        
        for (int l : lost) lostList.add(l);
        for (int r : reserve) reserveList.add(r);
        
        List<Integer> tempLost = new ArrayList<>(lostList);
        for (int student : tempLost) {
            if (reserveList.contains(student)) {
                lostList.remove((Integer) student);
                reserveList.remove((Integer) student);
            }
        }
        
        int count = n - lostList.size();

        for (int student : lostList) {
            int left = student - 1;
            int right = student + 1;

            if (reserveList.contains(left)) {
                reserveList.remove((Integer) left);
                count++;
            } else if (reserveList.contains(right)) {
                reserveList.remove((Integer) right);
                count++;
            }
        }

        return count;
    }
}