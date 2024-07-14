import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int min = Integer.MAX_VALUE;
    static int result;

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static void bfs(int start) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(new Pair(start, 0));
        visited[start] = true;

        int temp = 0;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int next : list.get(pair.index)) {
                if (!visited[next]) {
                    temp += pair.count + 1;
                    visited[next] = true;
                    queue.add(new Pair(next, pair.count + 1));
                }
            }
        }

        if (temp < min) {
            min = temp;
            result = start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        System.out.println(result);
    }
}

class Pair {
    int index;
    int count;

    public Pair(int index, int count) {
        this.index = index;
        this.count = count;
    }
}