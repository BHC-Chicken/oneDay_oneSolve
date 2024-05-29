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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n));
    }

    static int bfs(int num) {
        Queue<Integer> q = new LinkedList<>();

        q.add(num);
        int temp = 0;
        visited[num] = 1;

        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp == k) {
                return visited[temp] - 1;
            }
            if (temp - 1 >= 0 && visited[temp - 1] == 0) {
                visited[temp - 1] = visited[temp] + 1;
                q.add(temp - 1);
            }
            if (temp + 1 <= 100000 && visited[temp + 1] == 0) {
                visited[temp + 1] = visited[temp] + 1;
                q.add(temp + 1);
            }
            if (2 * temp <= 100000 && visited[2 * temp] == 0) {
                visited[2 * temp] = visited[temp] + 1;
                q.add(2 * temp);
            }
        }

        return -1;
    }
}