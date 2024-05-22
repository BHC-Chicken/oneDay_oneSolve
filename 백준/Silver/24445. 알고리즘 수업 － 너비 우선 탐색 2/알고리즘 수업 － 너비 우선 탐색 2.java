import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int v;
    static ArrayList<Integer> arr[];
    static boolean[] isVisit;
    static int[] order;
    static int count = 1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        isVisit = new boolean[n + 1];
        order = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            arr[i].sort(Collections.reverseOrder());
        }

        isVisit = new boolean[n + 1];
        bfs(v);

        for (int i = 1; i <= n; i++) {
            sb.append(order[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(index);
        isVisit[index] = true;
        order[index] = count++;

        while (!queue.isEmpty()) {
            int a = queue.poll();

            for (int i : arr[a]) {
                if (!isVisit[i]) {
                    queue.add(i);
                    isVisit[i] = true;
                    order[i] = count++;
                }
            }
        }
    }
}