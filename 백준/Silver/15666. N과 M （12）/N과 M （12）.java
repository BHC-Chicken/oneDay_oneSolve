import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr, result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        result = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(1, 0);

        System.out.println(sb);

    }

    static void dfs(int start, int depth) {
        if (depth == m) {
            for (int a : result) {
                sb.append(a).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = start; i <= n; i++) {
            if (arr[i - 1] == arr[i]) {
                continue;
            }

            result[depth] = arr[i];
            dfs(i, depth + 1);
        }
    }
}
