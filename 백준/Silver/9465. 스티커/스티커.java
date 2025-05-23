import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());

            int[][] cost = new int[2][n];
            int[][] dp = new int[2][n];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                cost[0][j] = Integer.parseInt(st1.nextToken());
                cost[1][j] = Integer.parseInt(st2.nextToken());
            }

            dp[0][0] = cost[0][0];
            dp[1][0] = cost[1][0];

            int max = Math.max(dp[0][0], dp[1][0]);

            for (int j = 1; j < n; j++) {
                if (j == 1) {
                    dp[0][1] = dp[1][0] + cost[0][1];
                    dp[1][1] = dp[0][0] + cost[1][1];

                    max = Math.max(dp[0][1], dp[1][1]);

                    continue;
                }

                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + cost[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + cost[1][j];

                max = Math.max(max, Math.max(dp[0][j], dp[1][j]));
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}
