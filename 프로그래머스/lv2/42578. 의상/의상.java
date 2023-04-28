import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(String[] clothe : clothes) {
            String kind = clothe[1];
            
            hashMap.put(kind, hashMap.getOrDefault(kind, 1) + 1);
        }
        
        for (int i : hashMap.values()) {
            answer *= i;
        }
        
        return answer - 1;
    }
}