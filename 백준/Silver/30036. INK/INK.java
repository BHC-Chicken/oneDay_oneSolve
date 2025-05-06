import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int i;
    static int n;
    static int k;
    static char[][] map;
    static char[] colors;
    static char[] cmd;

    static Pair now;
    static int ink = 0;
    static int colorIndex = 0;

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n && map[x][y] == '.';
    }

    static void coloring() {
        char nowColor = colors[colorIndex];

        int minX = Math.max(0, now.x - ink);
        int maxX = Math.min(n - 1, now.x + ink);
        int minY = Math.max(0, now.y - ink);
        int maxY = Math.min(n - 1, now.y + ink);

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                int value = Math.abs(now.x - i) + Math.abs(now.y - j);

                if (value <= ink) {
                    if (map[i][j] == '#' || (map[i][j] >= 'A' && map[i][j] <= 'Z')) {
                        map[i][j] = nowColor;
                    }
                }
            }
        }

        ink = 0;
    }

    static void move(char c) {
        int nx = now.x;
        int ny = now.y;

        if (c == 'U') {
            nx = now.x - 1;

            if (inRange(nx, ny)) {
                now.x = nx;
            }
        } else if (c == 'D') {
            nx = now.x + 1;

            if (inRange(nx, ny)) {
                now.x = nx;
            }
        } else if (c == 'L') {
            ny = now.y - 1;

            if (inRange(nx, ny)) {
                now.y = ny;
            }
        } else if (c == 'R') {
            ny = now.y + 1;

            if (inRange(nx, ny)) {
                now.y = ny;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        i = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][n];
        colors = br.readLine().toCharArray();

        for (int i = 0; i < n; i++) {
            String color = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = color.charAt(j);

                if (color.charAt(j) == '@') {
                    now = new Pair(i, j);
                    map[i][j] = '.';
                }
            }
        }

        cmd = br.readLine().toCharArray();

        for (int i = 0; i < k; i++) {
            char c = cmd[i];

            if (c == 'j') {
                ink++;
            } else if (c == 'J') {
                if (ink >= 1) {
                    coloring();
                }

                colorIndex = (colorIndex + 1) % colors.length;
            } else {
                move(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        map[now.x][now.y] = '@';

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
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