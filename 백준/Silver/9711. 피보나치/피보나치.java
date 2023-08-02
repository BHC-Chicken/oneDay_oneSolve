import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[10001];
        StringTokenizer st;

        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.ONE;
        dp[3] = BigInteger.TWO;
        dp[4] = BigInteger.valueOf(3);

        for (int i = 5; i < 10001; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        for (int i = 1; i <= test_case; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(i).append(": ").append(dp[p].mod(BigInteger.valueOf(q))).append("\n");
        }

        System.out.println(sb);
    }
}
