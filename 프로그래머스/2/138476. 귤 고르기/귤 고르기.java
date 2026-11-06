import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        List<Pair> list = new ArrayList<>();
        
        for (int key : map.keySet()) {
            list.add(new Pair(key, map.get(key)));
        }
        
        list.sort((p1, p2) -> {
            return p2.value - p1.value;
        });
        
        int total = 0;
        
        for (Pair p : list) {
            total += p.value;
            answer++;
            
            if (total >= k) {
                break;
            }
        }
        
        return answer;
    }
}

class Pair {
    int index;
    int value;
    
    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }
}