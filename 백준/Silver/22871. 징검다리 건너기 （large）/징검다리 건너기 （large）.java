import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long[] arr;
    static long[] dp;

    static long jump(int num) {
        if (num == n - 1) {
            return 0;
        }

        if (dp[num] != -1) {
            return dp[num];
        }

        dp[num] = Long.MAX_VALUE;

        for (int i = num + 1; i < n; i++) {
            dp[num] = Math.min(dp[num], Math.max(jump(i), (i - num) * (1 + Math.abs(arr[num] - arr[i]))));
        }

        return dp[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        dp = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            dp[i] = -1;
        }

        System.out.println(jump(0));
    }
}
