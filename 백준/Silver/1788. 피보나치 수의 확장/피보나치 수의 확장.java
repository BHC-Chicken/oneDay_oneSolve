import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        if (num > 0) {
            sb.append(1).append("\n");
        } else if (num < 0) {
            num = -num;
            if (num % 2 == 0) {
                sb.append(-1).append("\n");
            } else {
                sb.append(1).append("\n");
            }
        } else {
            sb.append(0).append("\n");
        }

        int[] dp = new int[1000001];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < num + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
        }
        sb.append(dp[num]);

        System.out.println(sb);
    }
}