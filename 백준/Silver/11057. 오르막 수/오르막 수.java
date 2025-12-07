import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][10];

        for (int j = 0; j <= 9; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] % 10007;
                } else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 10007;
                }
            }
        }

        int sum = 0;
        for (int j = 0; j <= 9; j++) {
            sum = (sum + dp[n][j]) % 10007;
        }

        System.out.println(sum);

    }
}
