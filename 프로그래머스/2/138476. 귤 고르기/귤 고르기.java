import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int answer = 0;
        
        for (int i : tangerine) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        for (int i : hashMap.keySet()) {
            list.add(hashMap.get(i));
        }
        list.sort(Collections.reverseOrder());
        
        for (int i : list) {
            sum += i;
            answer++;
            if (sum >= k) {
                break;
            }
        }
        
        return answer;
    }
}