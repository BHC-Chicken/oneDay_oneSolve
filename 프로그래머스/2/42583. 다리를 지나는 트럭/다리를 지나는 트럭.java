import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(
        int bridge_length,
        int weight,
        int[] truck_weights
    ) {
        int time = 0;
        int totalWeight = 0;

        Queue<int[]> bridge = new ArrayDeque<>();

        for (int truck : truck_weights) {
            time++;

            while (!bridge.isEmpty()
                    && bridge.peek()[1] <= time) {
                totalWeight -= bridge.poll()[0];
            }

            while (totalWeight + truck > weight
                    || bridge.size() >= bridge_length) {

                time = bridge.peek()[1];

                while (!bridge.isEmpty()
                        && bridge.peek()[1] <= time) {
                    totalWeight -= bridge.poll()[0];
                }
            }

            bridge.offer(
                new int[]{truck, time + bridge_length}
            );
            totalWeight += truck;
        }

        return time + bridge_length;
    }
}