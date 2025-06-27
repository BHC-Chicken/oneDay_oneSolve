import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Pair> list;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        list = new ArrayList<>();

        int size = -1;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            map[x][y] = 1;
            list.add(new Pair(x, y));
        }

        for (Pair value : list) {
            if (visited[value.x][value.y]) {
                continue;
            }

            ArrayDeque<Pair> queue = new ArrayDeque<>();
            queue.add(value);
            int count = 1;

            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                int x = pair.x;
                int y = pair.y;

                visited[x][y] = true;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (inRange(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new Pair(nx, ny));
                        count++;
                        visited[nx][ny] = true;
                    }
                }
            }
            size = Math.max(size, count);
        }

        System.out.println(size);
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
