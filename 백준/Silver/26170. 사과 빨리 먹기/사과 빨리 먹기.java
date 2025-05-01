import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean result;
    static int total = Integer.MAX_VALUE;
    static boolean[][] visited = new boolean[5][5];

    static boolean inRange(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static void dfs(int x, int y, int count, int depth) {
        if (count >= 3) {
            result = true;
            total = Math.min(total, depth);

            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (inRange(nx, ny) && !visited[nx][ny] && map[nx][ny] != -1) {
                visited[nx][ny] = true;
                dfs(nx, ny, count + map[nx][ny], depth + 1);
                visited[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[5][5];
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        visited[startX][startY] = true;
        dfs(startX, startY, map[startX][startY], 0);

        if (result) {
            System.out.println(total);

            return;
        }

        System.out.println(-1);
    }
}
