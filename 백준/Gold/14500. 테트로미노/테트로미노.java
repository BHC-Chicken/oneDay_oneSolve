import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int max;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static void dfs(int x, int y, int count, int sum) {
        if (count == 4) {
            max = Math.max(max, sum);

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!inRange(nx, ny)) {
                continue;
            }

            if (!visited[nx][ny]) {
                if (count == 2) {
                    visited[nx][ny] = true;
                    dfs(x, y, count + 1, sum + map[nx][ny]);
                }

                visited[nx][ny] = true;
                dfs(nx, ny, count + 1, sum + map[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }
}

