import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();

        int oneCount = 0;
        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 1) {
                plusQueue.add(num);
            } else if (num == 1) {
                oneCount++;
            } else if (num == 0) {
                zeroCount++;
            } else {
                minusQueue.add(num);
            }
        }

        long result = 0;

        while (plusQueue.size() > 1) {
            int a = plusQueue.poll();
            int b = plusQueue.poll();

            result += (long) a * b;
        }

        if (!plusQueue.isEmpty()) {
            result += plusQueue.poll();
        }

        // 2. 음수 처리
        while (minusQueue.size() > 1) {
            int a = minusQueue.poll();
            int b = minusQueue.poll();

            result += (long) a * b;
        }

        if (!minusQueue.isEmpty()) {
            if (zeroCount == 0) {
                result += minusQueue.poll();
            }
        }

        result += oneCount;

        System.out.println(result);
    }
}
