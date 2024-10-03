import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w;
    static int h;
    static int count;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0, -1, 1, 1, -1};
    static int[] dy = {0, 1, 0, -1, -1, 1, -1, 1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w;
    }

    static void bfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if (inRange(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Pair(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        while (w != 0 && h != 0) {
            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        count += 1;
                        bfs(i, j);
                    }
                }
            }

            sb.append(count).append("\n");

            count = 0;
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}