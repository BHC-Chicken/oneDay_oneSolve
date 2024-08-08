import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    static boolean search(int x1, int y1, int x2, int y2) {
        int prev = map[x1][y1];
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (prev != map[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    static void divide(int x1, int y1, int x2, int y2) {
        if (search(x1, y1, x2, y2)) {
            sb.append(map[x1][y1]);

            return;
        }

        int midX = (x1 + x2) / 2;
        int midY = (y1 + y2) / 2;

        sb.append("(");
        divide(x1, y1, midX, midY);
        divide(x1, midY, midX, y2);
        divide(midX, y1, x2, midY);
        divide(midX, midY, x2, y2);
        sb.append(")");

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }

        divide(0, 0, n, n);

        System.out.println(sb);
    }
}
