import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> resultList = new ArrayList<>();
        Queue<Pair> pairQueue = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            pairQueue.add(new Pair(progresses[i], i));
        }
        
        int count = 0;
        
        while(!pairQueue.isEmpty()) {
            boolean flag = false;
            int size = pairQueue.size();
            
            for (int i = 0; i < size; i++) {
                Pair pair = pairQueue.poll();
                pair.value = pair.value + speeds[pair.index];
                pairQueue.add(pair);
            }
            
            if (pairQueue.peek().value >= 100) {
                flag = true;
                
                for (int i = 0; i < size; i++) {
                    if (pairQueue.peek().value >= 100) {
                        count++;
                        pairQueue.poll();
                    } else {
                        break;
                    }
                }
            }
            
            if (flag) {
                resultList.add(count);
                count = 0;
            }
        }
        
        int[] result = new int[resultList.size()];
        
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        
        return result;
    }
}

class Pair {
    int value;
    int index;
    
    public Pair (int value, int index) {
        this.value = value;
        this.index = index;
    }
}