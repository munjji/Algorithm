import java.util.*;

public class Solution {
    public String solution(long n, String[] bans) {
        // bans 배열에 있는 각 문자열을 26진법의 숫자로 변환 후 정렬하여 배열로 저장
        long[] bases = Arrays.stream(bans)
                .mapToLong(this::convertStringToBase26)
                .sorted()
                .toArray();

        // 목표 위치 설정
        long target = n;

        // 삭제된 주문이 있는 경우, target을 조정
        for (long base : bases) {
            // 삭제 주문이 있으면 해당 주문의 개수만큼 늘어나야 원래 주문의 위치가 됨
            if (target >= base) {
                ++target;
            } else {
                break;
            }
        }
        // 26진법 숫자 -> 문자열로 변환
        return convertToBase26(target);
    }

    // 1 -> "a", 2-> "b" 등
    private String convertToBase26(long num) {
        StringBuilder result = new StringBuilder();
        long number = num;

        while (number-- > 0) {
            char c = (char) ('a' + (number % 26));
            result.append(c);
            number /= 26;
        }

        return result.reverse().toString();
    }

    // 문자열을 26진법 숫자로 변환
    private long convertStringToBase26(String input) {
        long result = 0;

        for (char c : input.toCharArray()) {
            int value = c - 'a' + 1;
            result = result * 26 + value;
        }
        return result;
    }
}