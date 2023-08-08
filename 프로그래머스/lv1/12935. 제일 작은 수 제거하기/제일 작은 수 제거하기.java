import java.util.List;
import java.util.ArrayList;

class Solution {
    static int[] answer;
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        answer = new int[arr.length - 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {
                continue;
            }
            list.add(arr[i]);
        }
        int index = 0;
        for (int i : list) {
            answer[index] = i;
            index++;
        }
        
        return answer;
    }
}