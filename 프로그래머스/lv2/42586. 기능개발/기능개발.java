import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> progress = new LinkedList<>();
        Queue<Integer> speed = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            progress.add(progresses[i]);
            speed.add(speeds[i]);
        }
        
        while(!progress.isEmpty()) {
            int size = progress.size();
            
            for (int i = 0; i < size; i++) {
                int pro = progress.poll();
                int spe = speed.poll();
                
                pro += spe;
                
                progress.add(pro);
                speed.add(spe);
            }
            
            int result = 0;
            
            for (int i = 0; i < size; i++) {
                if (progress.peek() >= 100) {
                    progress.poll();
                    speed.poll();
                    result++;
                }
            }
            if (result > 0) {
                list.add(result);
            }
        }
        
        int[] answer = new int[list.size()];
        int index = 0;
        
        for (int i : list) {
            answer[index] = i;
            index++;
        }
        
        return answer;
    }
}