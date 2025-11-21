import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static int[] arr;
    static int total;
    static int result;
    static int STRENGTH = 500;
    static boolean[] visited;

    static void dfs(int depth) {
        if (depth == n) {
            result++;

            return;
        }

        if (STRENGTH + total < 500) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i] && STRENGTH - k + arr[i] >= 500) {
                STRENGTH -= k;
                visited[i] = true;
                STRENGTH += arr[i];
                total -= arr[i];
                dfs(depth + 1);
                visited[i] = false;
                STRENGTH -= arr[i];
                total += arr[i];
                STRENGTH += k;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        dfs(0);

        System.out.println(result);
    }
}
