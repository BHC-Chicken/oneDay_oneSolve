import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long queue1Sum = 0;
        long queue2Sum = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i <queue1.length ; i++) {
            q1.add(queue1[i]);
            queue1Sum += queue1[i];

            q2.add(queue2[i]);
            queue2Sum += queue2[i];
        }

        while (queue1Sum != queue2Sum) {
            if (answer > (q1.size() + q2.size()) * 2) {
                return -1;
            }
            
            if (queue1Sum > queue2Sum) {
                int temp = q1.poll();
                q2.add(temp);
                
                queue1Sum -= temp;
                queue2Sum += temp;
            } else if (queue1Sum < queue2Sum) {
                int temp = q2.poll();
                q1.add(temp);

                queue1Sum += temp;
                queue2Sum -= temp;
            }
            
            answer += 1;
        }
        
        return answer;
    }
}