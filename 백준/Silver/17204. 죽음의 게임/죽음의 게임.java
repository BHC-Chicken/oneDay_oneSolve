import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] students = new int[n];

        for (int i = 0; i < n; i++) {
            students[i] = Integer.parseInt(br.readLine());
        }

        boolean[] visited = new boolean[n];
        int current = 0;
        int count = 0;

        while (!visited[current]) {
            if (current == k) {
                System.out.println(count);

                return;
            }

            visited[current] = true;
            current = students[current];
            count++;
        }

        System.out.println(-1);
    }
}
