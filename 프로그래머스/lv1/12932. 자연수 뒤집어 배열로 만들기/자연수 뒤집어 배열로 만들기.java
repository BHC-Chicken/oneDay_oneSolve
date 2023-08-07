import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Long> list = new ArrayList<>();
        
        while (n != 0) {
            list.add(n%10L);
            n /= 10L;
        }
        
        int index = 0;
        int[] answer = new int[list.size()];
        for (long a : list) {
            answer[index] = (int) a;
            index++;
        }
        
        return answer;
    }
}