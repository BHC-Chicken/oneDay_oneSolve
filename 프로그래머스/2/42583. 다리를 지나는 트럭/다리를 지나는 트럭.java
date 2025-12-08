import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;

        Queue<Integer> queue = new ArrayDeque<>();

        for (int truck : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.add(truck);
                    totalWeight += truck;
                    answer++;
                    break;
                } else if (bridge_length == queue.size()) {
                    totalWeight -= queue.poll();
                } else {
                    if (totalWeight + truck <= weight) {
                        queue.add(truck);
                        totalWeight += truck;
                        answer++;
                        break;
                    } else {
                        queue.add(0);
                        answer++;
                    }
                }
            }
        }
        
        return answer + bridge_length;
    }
}