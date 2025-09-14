import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int endMax = 0;

        ArrayList<Pair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Pair((start / 100) * 60 + (start % 100) - 10, (end / 100) * 60 + (end % 100) + 10));
        }

        Collections.sort(list);

        result = Math.max(result, list.get(0).start - 600);

        for (int i = 1; i < n; i++) {
            endMax = Math.max(endMax, list.get(i - 1).end);

            if (list.get(i).start > endMax) {
                result = Math.max(result, list.get(i).start - endMax);
            }
        }

        list.sort(Comparator.comparingInt(p -> p.end));
        result = Math.max(result, 1320 - list.get(n - 1).end);

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
        return Integer.compare(start, o.start);
    }
}