import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[] out;
    static boolean[] visited;

    static LinkedHashSet<String> list = new LinkedHashSet<>();

    static void dfs(int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < m; i++) {
                sb.append(out[i]).append(" ");
            }

            list.add(sb.toString().trim());

            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        out = new int[m];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        StringBuilder result = new StringBuilder();

        for (String s : list) {
            result.append(s).append("\n");
        }

        System.out.println(result);
    }
}
