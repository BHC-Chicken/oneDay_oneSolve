import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        dfs(1, 0);

        System.out.println(sb);
    }

    static void dfs(int a, int num) {
        if (num == m) {
            for (int b : arr) {
                sb.append(b).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = a; i <= n; i++) {
            arr[num] = i;
            dfs(i + 1, num + 1);
        }
    }
}