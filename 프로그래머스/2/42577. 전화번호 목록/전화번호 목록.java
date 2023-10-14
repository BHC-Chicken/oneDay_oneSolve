import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : phone_book) {
            map.put(s, 1);
        }
        
        for (String s : phone_book) {
            for (int i = 1; i < s.length(); i++) {
                String prefix = s.substring(0, i);
                if (map.containsKey(prefix)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}