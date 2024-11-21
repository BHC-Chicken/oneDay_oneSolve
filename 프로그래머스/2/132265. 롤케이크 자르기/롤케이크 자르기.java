import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        map1.put(topping[0], 1);

        for (int i = 1; i < topping.length; i++) {
            map2.put(topping[i], map2.getOrDefault(topping[i], 0) + 1);
        }

        if (map2.isEmpty()) {

            return 0;
        }

        if (map1.size() == map2.size()) {
            answer += 1;
        }

        for (int i = 1; i < topping.length; i++) {
            map1.put(topping[i], 1);

            if (map2.containsKey(topping[i])) {
                map2.merge(topping[i], -1, Integer::sum);

                if (map2.get(topping[i]) == 0) {
                    map2.remove(topping[i]);
                }
            }

            if (map1.size() == map2.size()) {
                answer += 1;
            }
        }
        
        return answer;
    }
}