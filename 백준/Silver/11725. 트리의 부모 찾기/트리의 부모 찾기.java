import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int loop = Integer.parseInt(br.readLine());
        StringTokenizer st;

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < loop; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < loop - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken()) - 1;

            list.get(n).add(m);
            list.get(m).add(n);
        }

        boolean[] visited = new boolean[loop];
        int[] arr = new int[loop];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int node : list.get(v)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    arr[node] = v;
                }
            }
        }
        for (int i = 1; i < loop; i++) {
            sb.append(arr[i] + 1).append("\n");
        }

        System.out.println(sb);
    }
}
