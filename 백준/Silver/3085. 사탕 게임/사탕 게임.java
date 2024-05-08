import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static String[][] arr;

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static void swap(int x1, int y1, int x2, int y2) {
        String temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    static int check() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            int temp = 1;
            for (int j = 1; j < n; j++) {
                if (arr[i][j].equals(arr[i][j - 1])) {
                    temp++;
                } else {
                    count = Math.max(temp, count);
                    temp = 1;
                }
            }

            count = Math.max(temp, count);
        }

        for (int i = 0; i < n; i++) {
            int temp = 1;
            for (int j = 1; j < n; j++) {
                if (arr[j][i].equals(arr[j - 1][i])) {
                    temp++;
                } else {
                    count = Math.max(temp, count);
                    temp = 1;
                }
            }

            count = Math.max(temp, count);
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = line[j];
            }
        }

        int[] dx = {0, 1};
        int[] dy = {1, 0};

        int cx = 0;
        int cy = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cx = i;
                cy = j;

                for (int k = 0; k < 2; k++) {
                    if (inRange(cx + dx[k], cy + dy[k])) {
                        swap(i, j, cx + dx[k], cy + dy[k]);
                        result = Math.max(result, check());
                        swap(i, j, cx + dx[k], cy + dy[k]);

                        if (result == n) {
                            System.out.println(result);

                            return;
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}
