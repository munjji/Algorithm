class Solution {
    public long solution(String numbers) {
        String[] string_numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < string_numbers.length; i++) {
            numbers = numbers.replaceAll(string_numbers[i], String.valueOf(i));
        }
        return Long.parseLong(numbers);
    }
}