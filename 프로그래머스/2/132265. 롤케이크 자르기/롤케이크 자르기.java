import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> su = new HashMap<>();
        Map<Integer, Integer> dong = new HashMap<>();
        
        su.put(topping[0], 1);
        
        for (int i = 1; i < topping.length; i++) {
            dong.put(topping[i], dong.getOrDefault(topping[i], 0) + 1);
        }
        
        if (su.size() == dong.size()) {
            answer++;
        }
        
        for (int i = 1; i < topping.length; i++) {
            int value = topping[i];
            su.put(value, 1);
            
            if (dong.containsKey(value)) {
                dong.put(value, dong.get(value) - 1);   
                
                if (dong.get(value) == 0) {
                    dong.remove(value);
                }
            }
            
            
            if (su.size() == dong.size()) {
               answer++;
            }
        }
        
        return answer;
    }
}