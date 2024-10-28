import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static boolean inRange(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static void mapInit(int n, int[][] map) {
        int end = n / 2;
        int start = end - 1;

        boolean color = true;

        for (int i = start; i < end + 1; i++) {
            for (int j = start; j < end + 1; j++) {
                if (color) {
                    map[i][j] = 2;

                    color = false;
                } else {
                    map[i][j] = 1;

                    color = true;
                }
            }

            color = false;
        }
    }

    static void reverse(int[][] map, int x, int y, int color) {
        int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
        int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};

        for (int i = 0; i < 8; i++) {
            if (!inRange(x + dx[i], y + dy[i], map.length) || map[x + dx[i]][y + dy[i]] == 0) {
                continue;
            }

            int nx = x + dx[i];
            int ny = y + dy[i];

            boolean flag = false;

            while (inRange(nx, ny, map.length) && map[nx][ny] != 0) {
                if (map[nx][ny] == color) {
                    flag = true;

                    break;
                }

                nx += dx[i];
                ny += dy[i];
            }

            nx = x + dx[i];
            ny = y + dy[i];

            if (flag) {
                while (map[nx][ny] != color) {
                    if (color == 1) {
                        map[nx][ny] = 1;
                    } else {
                        map[nx][ny] = 2;
                    }

                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= tc; testCase++) {
            String[] line = br.readLine().split(" ");

            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);

            int[][] map = new int[n][n];
            mapInit(n, map);

            for (int i = 0; i < m; i++) {
                line = br.readLine().split(" ");

                int x = Integer.parseInt(line[1]) - 1;
                int y = Integer.parseInt(line[0]) - 1;
                int color = Integer.parseInt(line[2]);

                map[x][y] = color;

                reverse(map, x, y, color);
            }

            int black = 0;
            int white = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) {
                        black += 1;
                    }
                    if (map[i][j] == 2) {
                        white += 1;
                    }
                }
            }

            sb.append("#").append(testCase).append(" ").append(black).append(" ").append(white).append("\n");
        }

        System.out.println(sb);
    }
}
