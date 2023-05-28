import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            for (int j = 0; j < i; j++) {
                list.add(i);
            }
        }
        int[] answer = new int[list.size()];
        int index = 0;
        for (int i : list) {
            answer[index] = i;
            index++;
        }
        return answer;
    }
}