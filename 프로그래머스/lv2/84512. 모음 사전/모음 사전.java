class Solution {
    public int solution(String word) {
        String str = "AEIOU";
        int[] value = {781, 156, 31, 6, 1};
        int index = word.length();
        int answer = word.length();
        
        for (int i = 0; i < word.length(); i++) {
            index = str.indexOf(word.charAt(i));
            answer += value[i] * index;
        }
        
        return answer;
    }
}