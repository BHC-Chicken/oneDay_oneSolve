import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(String[] clothe : clothes) {
            String kind = clothe[1];
            
            hashMap.put(kind, hashMap.getOrDefault(kind, 0) + 1);
        }
        
        for (int i : hashMap.values()) {
            answer *= (i + 1);
        }
        
        return answer - 1;
    }
}