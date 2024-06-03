import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[] visited = new boolean[100001];

    static int vertex;
    static int edge;
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());

        map = new int[vertex + 1][vertex + 1];
        visited = new boolean[vertex + 1];

        for (int i = 0; i < edge; i++) {

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map[u][v] = 1;
            map[v][u] = 1;
        }

        for (int i = 1; i <= vertex; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int index) {
        if (visited[index]) {
            return;
        }

        visited[index] = true;

        for (int i = 1; i <= vertex; i++) {
            if (map[index][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}