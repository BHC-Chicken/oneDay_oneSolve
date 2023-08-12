import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] answer = new int[s.length()];
        int index = 0;

        for (int i = 0; i < s.length(); i++) {
            map.replaceAll((k, v) -> map.get(k) + 1);

            char c = s.charAt(i);

            if (!map.containsKey(c)) {
                answer[index] = -1;
                map.put(c, 0);
                index++;
            } else {
                answer[index] = map.get(c);
                map.put(c, 0);
                index++;
            }
        }
        return answer;
    }
}