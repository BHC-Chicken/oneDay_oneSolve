import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Queue<Pair> queue = new ArrayDeque<>();

        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");

            queue.add(new Pair(input[0], Integer.parseInt(input[1])));
        }

        while (queue.size() > 1) {
            Pair pair = queue.poll();

            for (int i = 0; i < pair.stdNum - 1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }

        System.out.println(queue.poll().name);
    }
}

class Pair {
    String name;
    int stdNum;

    public Pair(String name, int stdNum) {
        this.name = name;
        this.stdNum = stdNum;
    }
}
