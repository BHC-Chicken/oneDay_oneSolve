import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int[] dp = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int a = 0; a < n; a++) {
                arr[a] = Integer.parseInt(st.nextToken());
            }
            int max = arr[0];
            dp[0] = arr[0];
            for (int a = 1; a < arr.length; a++) {
                if (dp[a - 1] < 0) {
                    dp[a - 1] = 0;
                }
                dp[a] = dp[a - 1] + arr[a];
                max = Math.max(max, dp[a]);
            }
            System.out.println(max);
        }
    }
}