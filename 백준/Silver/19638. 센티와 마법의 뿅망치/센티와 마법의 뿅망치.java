import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int n = Integer.parseInt(split[0]);
        int h = Integer.parseInt(split[1]);
        int t = Integer.parseInt(split[2]);
        int loop = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < t; i++) {
            int num = queue.poll();

            if (num < h) {
                break;
            }

            if (num != 1) {
                queue.add(num / 2);
            } else {
                queue.add(num);
            }
            loop += 1;
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num >= h) {
                System.out.println("NO");
                System.out.println(num);

                return;
            }
        }

        System.out.println("YES");
        System.out.println(loop);
    }
}
