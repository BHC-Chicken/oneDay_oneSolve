import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] map = new int[101];
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a] = b;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a] = b;
        }

        int[] count = new int[101];
        boolean[] visited = new boolean[101];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        count[1] = 0;
        visited[1] = true;

        while (!queue.isEmpty()) {
            int start = queue.poll();

            if (start == 100) {
                System.out.println(count[start]);

                return;
            }

            for (int i = 1; i <= 6 ; i++) {
                int next = start + i;

                if (next > 100) {
                    continue;
                }

                if (visited[next]) {
                    continue;
                }

                visited[next] = true;

                if (map[next] != 0) {
                    if (!visited[map[next]]) {
                        queue.add(map[next]);
                        visited[map[next]] = true;
                        count[map[next]] = count[start] + 1;
                    }
                } else {
                    queue.add(next);
                    count[next] = count[start] + 1;
                }
            }
        }
    }
}
