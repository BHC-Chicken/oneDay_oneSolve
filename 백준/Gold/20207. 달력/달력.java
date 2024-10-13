import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        ArrayList<Pair> list = new ArrayList<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }

            return o1.end - o2.end;
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Pair(a, b));
        }

        Collections.sort(list);

        Pair start = list.get(0);

        int lengthStart = start.start;
        int lengthEnd = start.end;
        int height = 1;

        queue.add(start);

        for (int i = 1; i < list.size(); i++) {
            Pair pair = list.get(i);

            while (!queue.isEmpty() && pair.start - queue.peek().end > 1) {
                queue.poll();
            }

            if (!queue.isEmpty() && pair.start - queue.peek().end == 1) {
                Pair temp = queue.poll();

                queue.add(new Pair(temp.start, pair.end));
                lengthEnd = Math.max(lengthEnd, pair.end);
            } else if (!queue.isEmpty() && queue.peek().end >= pair.start) {
                queue.add(pair);

                height = Math.max(height, queue.size());
                lengthEnd = Math.max(lengthEnd, pair.end);
            } else {
                result += (lengthEnd - lengthStart + 1) * height;

                lengthStart = pair.start;
                lengthEnd = pair.end;
                height = 1;

                queue.add(pair);
            }
        }

        result += (lengthEnd - lengthStart + 1) * height;

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
        if (this.start == o.start) {
            return this.end - o.end;
        }

        return this.start - o.start;
    }
}
