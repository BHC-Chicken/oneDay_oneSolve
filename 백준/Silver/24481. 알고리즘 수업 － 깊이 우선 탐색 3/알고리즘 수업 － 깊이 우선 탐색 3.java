import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int r;

    static int[] visited;
    static ArrayList<ArrayList<Integer>> list;

    static void dfs(int start, int depth) {
        visited[start] = depth;

        for (int i : list.get(start)) {
            if (visited[i] != -1) {
                continue;
            }

            dfs(i, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        visited = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        Arrays.fill(visited, -1);
        visited[r] = 0;

        dfs(r, 0);

        for (int i = 1; i <= n; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
    }
}
