import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list;

        for (int size = 0; size < commands.length; size++) {
            list = new ArrayList<>();

            int i = commands[size][0];
            int j = commands[size][1];
            int k = commands[size][2];

            for (int l = i - 1; l < j; l++) {
                list.add(array[l]);
            }

            Collections.sort(list);

            answer[size] = list.get(k - 1);
        }
        
        return answer;
    }
}