import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        while (n != 1) {
            list.add(n);
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (3 * n) + 1;
            }
        }
        
        list.add(1);
        
        int[] answer = new int[list.size()];
        int index = 0;
        
        for (int i : list) {
            answer[index] = i;
            index++;
        }
        
        return answer;
    }
}