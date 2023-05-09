import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int max = -1;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < num; i++) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
            max = Math.max(max, map.get(key));
        }

        PriorityQueue<String> queue = new PriorityQueue<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                queue.add(entry.getKey());
            }
        }
        System.out.println(queue.poll());
    }
}
