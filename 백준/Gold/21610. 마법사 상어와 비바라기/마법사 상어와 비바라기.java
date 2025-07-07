import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] cloud;
    static ArrayDeque<Pair> pairs = new ArrayDeque<>();

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static void cloudMove(int d, int s) {
        int size = pairs.size();
        boolean[][] temp = new boolean[n][n];
        s %= n;

        for (int i = 0; i < size; i++) {
            Pair pair = pairs.poll();

            int nx = (pair.x + dx[d] * s) % n;
            int ny = (pair.y + dy[d] * s) % n;

            if (nx < 0) nx += n;
            if (ny < 0) ny += n;

            map[nx][ny]++;
            temp[nx][ny] = true;
            pairs.add(new Pair(nx, ny));
        }

        cloud = temp;
    }

    static void copyRain() {
        int size = pairs.size();

        for (int i = 0; i < size; i++) {
            Pair pair = pairs.poll();
            int count = 0;

            for (int j = 1; j < 8; j += 2) {
                int nx = pair.x + dx[j];
                int ny = pair.y + dy[j];

                if (inRange(nx, ny) && map[nx][ny] > 0) {
                    count++;
                }
            }

            map[pair.x][pair.y] += count;
        }
    }

    static void makeCloud() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cloud[i][j]) {
                    cloud[i][j] = false;
                } else if (!cloud[i][j] && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    cloud[i][j] = true;
                    pairs.add(new Pair(i, j));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int result = 0;

        map = new int[n][n];
        cloud = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloud[n - 1][0] = true;
        cloud[n - 1][1] = true;
        cloud[n - 2][0] = true;
        cloud[n - 2][1] = true;

        pairs.add(new Pair(n - 1, 0));
        pairs.add(new Pair(n - 1, 1));
        pairs.add(new Pair(n - 2, 0));
        pairs.add(new Pair(n - 2, 1));

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            cloudMove(d, s);
            copyRain();
            makeCloud();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result += map[i][j];
            }
        }

        System.out.println(result);
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
