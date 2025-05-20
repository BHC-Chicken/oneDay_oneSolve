import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        ArrayList<Pair> list = new ArrayList<>();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i : map.keySet()) {
            list.add(new Pair(i, map.get(i)));
        }

        Collections.sort(list);

        for (Pair pair : list) {
            for (int j = 0; j < pair.count; j++) {
                sb.append(pair.num).append(" ");
            }
        }

        System.out.println(sb);
    }
}

class Pair implements Comparable<Pair> {
    int num;
    int count;

    public Pair(int num, int count) {
        this.num = num;
        this.count = count;
    }


    @Override
    public int compareTo(Pair o) {
        return o.count - this.count;
    }
}
