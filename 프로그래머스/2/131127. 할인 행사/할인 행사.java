import java.util.*;

class Solution {
    public boolean validation(String[] want, int[] number, Map<String, Integer> map) {
        for (int j = 0; j < want.length; j++) {
            if (!map.containsKey(want[j])) {
                return false;
            }
            
            if (map.get(want[j]) < number[j]) {
                return false;
            }
        }
        
        return true;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < 10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        if (validation(want, number, map)) {
            answer++;
        }
        
        for (int i = 10; i < discount.length; i++) {
            String item = discount[i];
            map.put(item, map.getOrDefault(item, 0) + 1);
            
            String remove = discount[i - 10];
            map.put(remove, map.get(remove) - 1);
            
            if(map.get(remove) < 0) {
                map.put(remove, 0);
            }
            
            if (validation(want, number, map)) {
                answer++;
            }
        }
        
        return answer;
    }
}