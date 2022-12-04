import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());
        int num1 = Integer.parseInt(br.readLine());

        int count = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < loop - 1; i++) {
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }

        if (loop == 1) {
            System.out.println(0);
            return;
        }

        while (true) {
            int num = 0;

            if (num1 > num && num1 > priorityQueue.peek()) {
                break;
            }

            if (!priorityQueue.isEmpty()) {
                num = priorityQueue.poll();
            }

            num = num - 1;
            priorityQueue.add(num);
            num1++;
            count++;
        }
        System.out.println(count);
    }
}