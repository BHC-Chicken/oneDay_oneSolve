import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;

    static boolean inRange(int x, int y) {
        return x >= 0 && x <= n && y >= 0 && y <= m;
    }

    static void queen(int x, int y) {
        for (int i = x + 1; i <= n; i++) {
            if (map[i][y] == 2) {
                break;
            }

            map[i][y] = 1;
        }

        for (int i = x - 1; i >= 0; i--) {
            if (map[i][y] == 2) {
                break;
            }

            map[i][y] = 1;
        }

        for (int i = y + 1; i <= m; i++) {
            if (map[x][i] == 2) {
                break;
            }

            map[x][i] = 1;
        }

        for (int i = y - 1; i >= 0; i--) {
            if (map[x][i] == 2) {
                break;
            }

            map[x][i] = 1;
        }

        int max = Math.max(n, m);

        for (int i = 1; i <= max; i++) {
            int nx = x + i;
            int ny = y + i;

            if (!inRange(nx, ny) || map[nx][ny] == 2) {
                break;
            }

            map[nx][ny] = 1;
        }

        for (int i = 1; i <= max; i++) {
            int nx = x - i;
            int ny = y - i;

            if (!inRange(nx, ny) || map[nx][ny] == 2) {
                break;
            }

            map[nx][ny] = 1;
        }

        for (int i = 1; i < max; i++) {
            int nx = x + i;
            int ny = y - i;

            if (!inRange(nx, ny) || map[nx][ny] == 2) {
                break;
            }

            map[nx][ny] = 1;
        }

        for (int i = 1; i < max; i++) {
            int nx = x - i;
            int ny = y + i;

            if (!inRange(nx, ny) || map[nx][ny] == 2) {
                break;
            }

            map[nx][ny] = 1;
        }
    }

    static void knight(int x, int y) {
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (inRange(nx, ny) && map[nx][ny] != 2) {
                map[nx][ny] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];

        ArrayList<ArrayList<Pair>> chess = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            chess.add(new ArrayList<>());

            ArrayList<Pair> pairs = chess.get(i);

            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num; j++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 2;

                pairs.add(new Pair(x, y));
            }
        }


        ArrayList<Pair> pairs = chess.get(0);

        for (Pair pair : pairs) {
            queen(pair.x, pair.y);
        }

        pairs = chess.get(1);

        for (Pair pair : pairs) {
            knight(pair.x, pair.y);
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
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
