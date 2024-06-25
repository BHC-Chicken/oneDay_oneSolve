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
    static Queue<Pair> queue = new LinkedList<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int day = 0;
        int count = 0;
        int fillPlace = 0;

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;

                if (num == 1) {
                    count++;
                    queue.add(new Pair(i, j));
                }
                if (num == 0) {
                    fillPlace++;
                }
            }
        }

        if (fillPlace == 0 && count > 0) {
            System.out.println(day);

            return;
        }

        if (fillPlace == 0 && count == 0) {
            System.out.println(-1);

            return;
        }

        count = 0;

        while (!queue.isEmpty()) {
            day++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();

                int px = pair.x;
                int py = pair.y;

                visited[px][py] = true;

                for (int j = 0; j < 4; j++) {
                    int nx = px + dx[j];
                    int ny = py + dy[j];

                    if (inRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0) {
                        count++;
                        map[nx][ny] = 1;
                        visited[nx][ny] = true;
                        queue.add(new Pair(nx, ny));
                    }
                }
            }
        }

        if (fillPlace == count) {
            System.out.println(day - 1);
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
