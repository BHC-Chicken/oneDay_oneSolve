import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static ArrayList<Pair> list = new ArrayList<>();

    static boolean inRange(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }

    static boolean gameOver(int x, int y) {
        if (!inRange(x, y)) {
            return true;
        }

        for (Pair pair : list) {
            if (pair.x == x && pair.y == y) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        int headX = 1;
        int headY = 1;
        list.add(new Pair(1, 1));

        int time = 0;

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
        }

        int index = 0;
        int l = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int distance = Integer.parseInt(st.nextToken());

            for (int j = time; j < distance; j++) {
                time++;
                int nx = headX + dx[index];
                int ny = headY + dy[index];

                if (gameOver(nx, ny)) {
                    System.out.println(time);

                    return;
                }

                headX = nx;
                headY = ny;
                list.add(new Pair(nx, ny));

                if (map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                } else {
                    list.remove(0);
                }
            }

            String dir = st.nextToken();

            if (dir.equals("D")) {
                index += 1;
                if (index >= 4) {
                    index = 0;
                }
            } else {
                index -= 1;
                if (index < 0) {
                    index = 3;
                }
            }
        }
        
        time++;
        int nx = headX + dx[index];
        int ny = headY + dy[index];

        while (!gameOver(nx, ny)) {
            headX = nx;
            headY = ny;
            list.add(new Pair(nx, ny));

            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
            } else {
                list.remove(0);
            }

            time++;
            nx = headX + dx[index];
            ny = headY + dy[index];
        }

        System.out.println(time);
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
