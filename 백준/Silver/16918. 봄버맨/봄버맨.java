import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static int n;
    static String[][] arr;
    static boolean[][] bomb;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    static void explosion() {
        bomb = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j].equals("O")) {
                    bomb[i][j] = true;

                    for (int k = 0; k < 4; k++) {
                        if (inRange(i + dx[k], j + dy[k])) {
                            bomb[i + dx[k]][j + dy[k]] = true;
                        }
                    }
                }
            }
        }
    }

    static void location() {
        arr = new String[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (bomb[i][j]) {
                    arr[i][j] = ".";
                } else {
                    arr[i][j] = "O";
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new String[r][c];
        bomb = new boolean[r][c];

        if (n % 2 == 0) {
            for (int i = 0; i < r; i++) {
                sb.append("O".repeat(Math.max(0, c)));
                sb.append("\n");
            }

            System.out.println(sb);

            return;
        }

        for (int i = 0; i < r; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                arr[i][j] = split[j];
                bomb[i][j] = !split[j].equals(".");
            }
        }

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                continue;
            }

            explosion();
            location();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
