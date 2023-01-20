import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int v;
    static ArrayList<Integer> arr[];
    static boolean[] isVisit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        isVisit = new boolean[n + 1];
        sb = new StringBuilder();

        for (int i = 0; i <arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);
        }

        for (int i = 0; i < arr.length; i++) {
            Collections.sort(arr[i]);
        }
        
        dfs(v);
        isVisit = new boolean[n + 1];
        sb.append("\n");
        bfs(v);

        System.out.println(sb);
    }

    public static void dfs(int index) {
        isVisit[index] = true;
        sb.append(index + " ");
        for (int i : arr[index]) {
            if (!isVisit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int index) {
        isVisit[index] = true;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(index);

        while (!queue.isEmpty()) {
            int a = queue.poll();
            sb.append(a + " ");
            for (int i : arr[a]) {
                if (!isVisit[i]) {
                    queue.add(i);
                    isVisit[i] = true;
                }
            }
        }
    }
}