import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n - k == 1) {
            sb.append(n).append(" ");

            for (int i = 1; i <= n - 1; i++) {
                sb.append(i).append(" ");
            }

            System.out.println(sb);

            return;
        }

        if (k == 0) {
            for (int i = 1; i <= n; i++) {
                sb.append(i).append(" ");
            }

            System.out.println(sb);

            return;
        }

        if (k == (n * (n - 1)) / 2) {
            for (int i = n; i >= 1; i--) {
                sb.append(i).append(" ");
            }

            System.out.println(sb);

            return;
        }

        int sum = 0;
        int index = n - 1;
        boolean[] visited = new boolean[n];

        while (index > 0) {
            if (sum + index <= k) {
                sum += index;
                visited[index] = true;
            }

            index--;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (visited[i]) {
                sb.append(i + 1).append(" ");
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                sb.append(i + 1).append(" ");
            }
        }

        System.out.println(sb);
    }
}
