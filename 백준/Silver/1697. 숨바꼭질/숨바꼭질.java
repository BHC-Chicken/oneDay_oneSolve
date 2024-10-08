import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static int[] visited = new int[100001];

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 0;

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num == k) {

                return visited[num];
            }

            if (num - 1 >= 0 && visited[num - 1] == 0) {
                queue.add(num - 1);
                visited[num - 1] = visited[num] + 1;
            }

            if (num + 1 <= 100000 && visited[num + 1] == 0) {
                queue.add(num + 1);
                visited[num + 1] = visited[num] + 1;
            }

            if (num * 2 <= 100000 && visited[num * 2] == 0) {
                queue.add(num * 2);
                visited[num * 2] = visited[num] + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }
}
