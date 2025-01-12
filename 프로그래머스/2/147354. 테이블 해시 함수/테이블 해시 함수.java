import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        ArrayList<int[]> list = new ArrayList<>(Arrays.asList(data));

        list.sort((pair1, pair2) -> {
            if (pair1[col - 1] == pair2[col - 1]) {
                return pair2[0] - pair1[0];
            }

            return Integer.compare(pair1[col - 1], pair2[col - 1]);
        });

        int modNum = row_begin;

        for (int i = row_begin - 1; i < row_end; i++) {
            int[] arr = list.get(i);
            int sum = 0;

            for (int k : arr) {
                sum += (k % modNum);
            }

            modNum++;
            answer = answer ^ sum;
        }

        return answer;
    }
}