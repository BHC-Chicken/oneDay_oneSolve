import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int j = 0; j < n; j++) {
            arr[j] = Integer.parseInt(st.nextToken());
            dp[j] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            for (int j = 1; j <= arr[i]; j++) {
                if (i + j < n) {
                    if (dp[i + j] > dp[i] + 1) {
                        dp[i + j] = dp[i] + 1;
                    }
                }
            }
        }

        if (dp[n - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);

            return;
        }

        System.out.println(dp[n - 1]);
    }
}
