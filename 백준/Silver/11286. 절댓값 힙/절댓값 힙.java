import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer a, Integer b) {
                        int tempA = Math.abs(a);
                        int tempB = Math.abs(b);

                        if (tempA > tempB) {
                            return tempA - tempB;
                        } else if (tempA == tempB) {
                            if (a > b) {
                                return 1;
                            } else {
                                return -1;
                            }
                        } else {
                            return -1;
                        }
                    }
                }
        );
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value != 0) {
                priorityQueue.add(value);
            } else if (priorityQueue.isEmpty()) {
                sb.append(0).append("\n");
            } else {
                sb.append(priorityQueue.poll()).append("\n");
            }
        }

        System.out.println(sb);
    }
}