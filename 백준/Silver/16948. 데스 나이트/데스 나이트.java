import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(r1, c1));
        visited[r1][c1] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if (inRange(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    map[nx][ny] = map[pair.x][pair.y] + 1;
                    queue.add(new Pair(nx, ny));

                    if (nx == r2 && ny == c2) {
                        System.out.println(map[nx][ny]);

                        return;
                    }
                }
            }
        }

        if (map[r2][c2] > 0) {
            System.out.println(map[r2][c2]);
        } else {
            System.out.println(-1);
        }
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

