import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int k, int m, int[] score) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        for (int i : score) {
            queue.add(i);
        }

        while (queue.size() >= m) {
            int min = Integer.MAX_VALUE;
            int sum = 0;

            for (int i = 0; i < m; i++) {
                if (min > queue.peek()) {
                    min = queue.peek();
                }
                queue.poll();
            }

            answer += (min * m);
        }
        
        return answer;
    }
}