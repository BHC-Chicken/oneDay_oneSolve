import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] mapA;
    static int[][] mapB;

    static boolean isSameMap() {
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mapA[i][j] != mapB[i][j]) {
                    flag = false;

                    break;
                }
            }

            if (!flag) {
                break;
            }
        }

        return flag;
    }

    static void changeMap(int startX, int startY) {
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (mapA[i][j] == 1) {
                    mapA[i][j] = 0;
                } else {
                    mapA[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        mapA = new int[n][m];
        mapB = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                mapA[i][j] = Integer.parseInt(line[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                mapB[i][j] = Integer.parseInt(line[j]);
            }
        }

        if (n < 3 || m < 3) {
            if (isSameMap()) {

                System.out.println(0);

                return;
            }

            System.out.println(-1);

            return;
        }

        int result = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (mapA[i][j] != mapB[i][j]) {
                    changeMap(i, j);
                    result++;
                }
            }
        }

        if (isSameMap()) {
            System.out.println(result);

            return;
        }

        System.out.println(-1);
    }
}
