import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Pair> list = new ArrayList<>();
        
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (int i : map.keySet()) {
            list.add(new Pair(i, map.get(i)));
        }
        
        list.sort((a, b) -> {
            return b.value - a.value;
        });
        
        int sum = 0;
        
        for (Pair pair : list) {
            sum += pair.value;
            result++;
            
            if (sum >= k) {
                
                break;
            }
        }
        
        return result;
    }
}

class Pair {
    int index;
    int value;
    
    public Pair (int index, int value) {
        this.index = index;
        this.value = value;
    }
}