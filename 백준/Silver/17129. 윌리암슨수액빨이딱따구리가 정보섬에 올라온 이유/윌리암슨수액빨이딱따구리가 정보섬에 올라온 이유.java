import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int result = Integer.MAX_VALUE;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static void bfs(Pair start) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if (inRange(nx, ny) && !visited[nx][ny] && map[nx][ny] != 1) {
                    visited[nx][ny] = true;
                    int count = pair.count + 1;
                    queue.add(new Pair(nx, ny, count));

                    if (map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5) {
                        result = Math.min(result, count);
                    }
                }
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
        Pair start = null;

        for (int i = 0; i < n; i++) {
            String[] numbers = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(numbers[j]);

                if (num == 2) {
                    start = new Pair(i, j, 0);
                    visited[i][j] = true;
                }

                map[i][j] = num;
            }
        }

        bfs(start);

        if (result == Integer.MAX_VALUE) {
            System.out.println("NIE");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("TAK").append("\n").append(result);

            System.out.println(sb);
        }
    }
}

class Pair {
    int x;
    int y;
    int count;

    public Pair(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
