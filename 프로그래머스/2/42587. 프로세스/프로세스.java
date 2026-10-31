import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair> queue = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; i++) {
            Pair pair = new Pair(i, priorities[i]);
            pq.add(priorities[i]);
            queue.add(pair);
        }
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            
            if (current.priority == pq.peek()) {
                pq.poll();
                answer++;
                
                if (current.index == location) {
                    return answer;
                }
            } else {
                queue.add(current);
            }
        }
        
        return answer;
    }
}

class Pair {
    int index;
    int priority;
    
    public Pair(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}