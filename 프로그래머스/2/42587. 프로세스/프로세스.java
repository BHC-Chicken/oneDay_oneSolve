import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        
        Queue<Integer> priority = new LinkedList<>();
        Queue<Integer> turn = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            priority.add(priorities[i]);
            turn.add(i);
        }
        
        int max = Collections.max(priority);
        
        while (!priority.isEmpty()) {
            int num = priority.poll();
            int t = turn.poll();
            
            if (num == max && t == location) {
                return answer;
            } else if (num == max) {
                answer++;
                max = Collections.max(priority);
            } else {
                priority.add(num);
                turn.add(t);
            }
        }
        
        return answer;
    }
}