import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[30][30];

    public static int com(int n, int m) {
        if (arr[n][m] > 0) {
            return arr[n][m];
        } else if (n == m || m == 0) {
            return arr[n][m] = 1;
        } else {
            return arr[n][m] =  com(n - 1, m - 1) + com(n - 1, m);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(com(m, n));
        }
    }
}