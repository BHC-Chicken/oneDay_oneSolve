import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;

    static int EARTH = -2;
    static int WALL = -1;
    static int ROAD = 0;
    static int BUILDING = 1;
    static int DESIGN = 2;
    static int DESTROY = 3;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Pair> earthquake = new ArrayDeque<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        int d = 0;
        int save = 0;

        for (int i = 0; i < n; i++) {
            char[] split = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (split[j] == '@') {
                    earthquake.add(new Pair(i, j));
                    map[i][j] = EARTH;
                } else if (split[j] == '.') {
                    map[i][j] = ROAD;
                } else if (split[j] == '*') {
                    map[i][j] = BUILDING;
                } else if (split[j] == '#') {
                    map[i][j] = DESIGN;
                } else if (split[j] == '|') {
                    map[i][j] = WALL;
                }
            }
        }

        Pair pair = earthquake.poll();

        for (int i = 0; i < 4; i++) {
            int nx = pair.x;
            int ny = pair.y;

            for (int j = 0; j < 2; j++) {
                nx += dx[i];
                ny += dy[i];

                if (inRange(nx, ny)) {
                    if (map[nx][ny] == WALL) {
                        break;
                    }
                    if (map[nx][ny] == DESIGN) {
                        map[nx][ny] = BUILDING;
                    } else if (map[nx][ny] == BUILDING) {
                        map[nx][ny] = DESTROY;
                        earthquake.add(new Pair(nx, ny));
                    }
                }
            }
        }


        while (!earthquake.isEmpty()) {
            pair = earthquake.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];

                if (inRange(nx, ny) && map[nx][ny] != WALL) {
                    if (map[nx][ny] == DESIGN) {
                        map[nx][ny] = BUILDING;
                    } else if (map[nx][ny] == BUILDING) {
                        map[nx][ny] = DESTROY;
                        earthquake.add(new Pair(nx, ny));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == DESTROY) {
                    d++;
                } else if (map[i][j] == BUILDING || map[i][j] == DESIGN) {
                    save++;
                }
            }
        }

        System.out.println(d + " " + save);
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
