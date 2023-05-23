import java.util.PriorityQueue;
import java.util.Queue;


class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville) {
            queue.add(i);
        }
        
        int min = queue.peek();
        
      
            while(queue.size() > 1 && K > min) {
                int sum = queue.poll() + (queue.poll() * 2);
                queue.add(sum);
                min = queue.peek();
                answer++;
            }
        
        if (K > min) {
            return -1;
        }
        
        
        return answer;
    }
}