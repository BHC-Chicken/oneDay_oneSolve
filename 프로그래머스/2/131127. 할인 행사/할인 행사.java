import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i = 0; i < discount.length - 9; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int count = 0;
            
            for (int j = i;j < i + 10; j++) {
                if(map.get(discount[j]) != null) {
                    map.put(discount[j], map.get(discount[j]) + 1);
                } else {
                    map.put(discount[j], 1);
                }
            }
            
            for (int j = 0; j < want.length; j++) {
                if(map.get(want[j]) == null || count == want.length) {
                    break;
                }
                
                if(map.get(want[j]) == number[j]) {
                    count++;
                }
            }
            
            if(count == want.length) {
                answer++;   
            }
        }
        
        return answer;
    }
}