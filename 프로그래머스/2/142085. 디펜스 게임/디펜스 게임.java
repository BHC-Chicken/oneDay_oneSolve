import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int j : enemy) {
            n -= j;
            queue.add(j);

            if (n < 0) {
                if (k > 0) {
                    n += queue.poll();
                    k--;
                } else {
                    break;
                }
            }

            answer++;
        }
        
        return answer;
    }
}