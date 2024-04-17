import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] star;

    static void expansion(int n, int m) {
        for (int i = n; i < m; i++) {
            star[n][i] = '*';
            star[m - 1][i] = '*';
            star[i][n] = '*';
            star[i][m - 1] = '*';
        }

        if (m <= n) {
            return;
        }

        expansion(n + 2, m - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = 4 * n - 3;

        star = new char[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                star[i][j] = ' ';
            }
        }

        expansion(0, m);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(star[i][j]);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
