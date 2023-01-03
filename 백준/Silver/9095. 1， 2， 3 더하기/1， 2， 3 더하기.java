import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        int[] dp = new int[11];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < test_case; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int a = 4; a <= num; a++) {
                dp[a] = dp[a - 1] + dp[a - 2] + dp[a - 3];
            }
            System.out.println(dp[num]);
        }
    }
}