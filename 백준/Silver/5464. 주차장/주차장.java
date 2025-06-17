import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int result = 0;

        int[] weight = new int[m + 1];
        Pair[] usePark = new Pair[m + 1];
        ArrayDeque<Integer> waitList = new ArrayDeque<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(p -> p.index));

        for (int i = 0; i < n; i++) {
            queue.add(new Pair(i, Integer.parseInt(br.readLine())));
        }

        for (int i = 1; i <= m; i++) {
            weight[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 2 * m; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 0) {
                if (!queue.isEmpty()) {
                    Pair poll = queue.poll();
                    result += (poll.cost * weight[num]);
                    usePark[num] = poll;
                } else {
                    waitList.add(num);
                    usePark[num] = null;
                }
            } else {
                queue.add(usePark[num * -1]);

                while (!queue.isEmpty() && !waitList.isEmpty()) {
                    int carNum = waitList.poll();
                    Pair pair = queue.poll();

                    result += (pair.cost * weight[carNum]);
                    usePark[carNum] = pair;
                }
            }
        }

        System.out.println(result);
    }
}

class Pair {
    int index;
    int cost;

    public Pair(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
}
