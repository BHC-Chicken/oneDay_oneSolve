import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;

        for (int i = 0; i < loop; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        while (!queue.isEmpty()) {
            if (!(queue.size() >= 3)) {
                break;
            }
            for (int i = 0; i < 2; i++) {
                sum += queue.poll();
            }
            queue.poll();
        }

        while (!queue.isEmpty()) {
            sum += queue.poll();
        }

        System.out.println(sum);
    }
}
