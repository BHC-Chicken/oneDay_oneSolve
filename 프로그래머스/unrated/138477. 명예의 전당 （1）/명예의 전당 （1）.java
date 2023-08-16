import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(int k, int[] score) {
        Queue<Integer> queue = new PriorityQueue<>();
        int[] answer = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            queue.add(score[i]);
            if (queue.size() > k) {
                queue.poll();
            }
            answer[i] = queue.peek();
        }
        
        return answer;
    }
}