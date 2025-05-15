import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;

    static int minus = 0;
    static int zero = 0;
    static int one = 0;

    static boolean check(int i, int j, int size) {
        boolean flag = true;
        int num = map[i][j];

        for (int k = i; k < i + size; k++) {
            for (int l = j; l < j + size; l++) {
                if (map[k][l] != num) {
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

    static void sum(int num, int size) {
        if (num == -1) {
            minus += 1;
        } else if (num == 0) {
            zero += 1;
        } else if (num == 1) {
            one += 1;
        }
    }

    static void recursive(int i, int j, int size) {
        if (check(i, j, size)) {
            sum(map[i][j], size);

            return;
        }

        size /= 3;

        recursive(i, j, size);
        recursive(i, j + size, size);
        recursive(i, j + (size * 2), size);
        recursive(i + size, j, size);
        recursive(i + size, j + size, size);
        recursive(i + size, j + (size * 2), size);
        recursive(i + (size * 2), j, size);
        recursive(i + (size * 2), j + size, size);
        recursive(i + (size * 2), j + (size * 2), size);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0, n);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }
}
