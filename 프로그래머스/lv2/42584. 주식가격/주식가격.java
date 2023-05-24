import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] prices) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i : prices) {
            list.add(i);
        }
        
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (int j = i + 1; j < list.size(); j++) {
                count++;
                if (list.get(i) > list.get(j)) {
                    break;
                }
            }
            answer[i] = count;
        }
    
    
        return answer;
    }
}