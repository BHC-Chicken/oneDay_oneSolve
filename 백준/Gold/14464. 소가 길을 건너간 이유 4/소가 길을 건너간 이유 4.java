import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int c = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int result = 0;

        int[] chickens = new int[c];
        Pair[] cows = new Pair[n];

        for (int i = 0; i < c; i++) {
            chickens[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            cows[i] = new Pair(start, end);
        }

        Arrays.sort(chickens);
        Arrays.sort(cows);

        int index = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < c; i++) {
            while (index < n && cows[index].start <= chickens[i]) {
                priorityQueue.add(cows[index++].end);
            }

            while (!priorityQueue.isEmpty() && priorityQueue.peek() < chickens[i]) {
                priorityQueue.poll();
            }

            if (!priorityQueue.isEmpty()) {
                result += 1;
                priorityQueue.poll();
            }
        }

        System.out.println(result);
    }
}

class Pair implements Comparable<Pair> {
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Pair o) {

        return Integer.compare(this.start, o.start);
    }
}
