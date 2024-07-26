import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Pair> pairs = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            map.put(i, 1);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pairs.add(new Pair(a, b));
        }

        Collections.sort(pairs);

        for (int i = 0; i < m; i++) {
            Pair pair = pairs.get(i);

            int aGet = map.get(pair.x);
            int bGet = map.get(pair.y);

            if (aGet >= bGet) {
                map.put(pair.y, aGet + 1);
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(map.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}

class Pair implements Comparable<Pair> {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.x, o.x);
    }
}