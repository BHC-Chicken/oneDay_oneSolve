import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);
        HashMap<Double, Integer> map = new HashMap<>();

        for (int w : weights) {
            double x = (double) w;
            double y = ((double) w * 2) / 3;
            double z = (double) w / 2;
            double k = ((double) w * 3) / 4;

            if (map.containsKey(x)) {
                answer += map.get(x);
            }

            if (map.containsKey(y)) {
                answer += map.get(y);
            }

            if (map.containsKey(z)) {
                answer += map.get(z);
            }

            if (map.containsKey(k)) {
                answer += map.get(k);
            }

            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        return answer;
    }
}