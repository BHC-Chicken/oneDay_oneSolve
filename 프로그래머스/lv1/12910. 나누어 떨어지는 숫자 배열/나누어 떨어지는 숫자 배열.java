import java.util.*;

class Solution {
    static int[] answer;
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        
        for (int i : arr) {
            if (i % divisor == 0) {
                list.add(i);
            }
        }
        
        if (list.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[list.size()];
            int index = 0;
            for (int i : list) {
                answer[index] = i;
                index++;
            }
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}