import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static String[][] map;

    static int minX = Integer.MAX_VALUE;
    static int minY = Integer.MAX_VALUE;
    static int maxX = Integer.MIN_VALUE;
    static int maxY = Integer.MIN_VALUE;

    static boolean rangeCheck(int nx, int ny) {
        int count = 0;

        if (upRow(nx, ny)) {
            count++;
        }
        if (downRow(nx, ny)) {
            count++;
        }
        if (leftCol(nx, ny)) {
            count++;
        }
        if (rightCol(nx, ny)) {
            count++;
        }

        return count >= 3;
    }

    static boolean upRow(int x, int y) {
        return x - 1 < 0 || map[x - 1][y].equals(".");
    }

    static boolean downRow(int x, int y) {
        return x + 1 >= r || map[x + 1][y].equals(".");
    }

    static boolean leftCol(int x, int y) {
        return y - 1 < 0 || map[x][y - 1].equals(".");
    }

    static boolean rightCol(int x, int y) {
        return y + 1 >= c || map[x][y + 1].equals(".");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new String[r][c];
        String[][] result = new String[r][c];

        for (int i = 0; i < r; i++) {
            String[] arr = br.readLine().split("");

            for (int j = 0; j < c; j++) {
                map[i][j] = arr[j];
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!map[i][j].equals(".")) {
                    if (rangeCheck(i, j)) {
                        result[i][j] = ".";
                    } else {
                        result[i][j] = "X";

                        minX = Math.min(minX, i);
                        minY = Math.min(minY, j);
                        maxX = Math.max(maxX, i);
                        maxY = Math.max(maxY, j);
                    }
                } else {
                    result[i][j] = ".";
                }
            }
        }

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
