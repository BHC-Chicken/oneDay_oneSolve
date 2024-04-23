import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int d;
    static int[][] arr;
    static int[][] copy;

    static void rotate() {
        for (int i = 0; i < n; i++) {
            copy[i][n / 2] = arr[i][i];
            copy[i][i] = arr[n / 2][i];
            copy[n / 2][i] = arr[n - i - 1][i];
            copy[n - i - 1][i] = arr[n - i - 1][n / 2];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = copy[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            arr = new int[n][n];
            copy = new int[n][n];

            if (d < 0) {
                d += 360;
            }

            d /= 45;

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    copy[j][k] = arr[j][k];
                }
            }

            for (int j = 0; j < d; j++) {
                rotate();
            }

            for (int[] ar : arr) {
                for (int num : ar) {
                    sb.append(num).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
