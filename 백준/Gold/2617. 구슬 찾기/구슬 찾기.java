import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] isHeavier = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st= new StringTokenizer(br.readLine());

            int heavier = Integer.parseInt(st.nextToken());
            int lighter = Integer.parseInt(st.nextToken());

            isHeavier[heavier][lighter] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (isHeavier[i][k] && isHeavier[k][j]) {
                        isHeavier[i][j] = true;
                    }
                }
            }
        }

        int mid = (n + 1) / 2;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            int light = 0;
            int heavy = 0;

            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }

                if (isHeavier[i][j]) {
                    light++;
                }

                if (isHeavier[j][i]) {
                    heavy++;
                }
            }

            if (light >= mid || heavy >= mid) {
                count++;
            }
        }

        System.out.println(count);
    }
}
