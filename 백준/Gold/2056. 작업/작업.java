import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            int prevCount = Integer.parseInt(st.nextToken());

            int maxPrevTime = 0;

            for (int j = 0; j < prevCount; j++) {
                int prevJob = Integer.parseInt(st.nextToken());
                maxPrevTime = Math.max(maxPrevTime, dp[prevJob]);
            }

            dp[i] = maxPrevTime + time;

            maxTime = Math.max(maxTime, dp[i]);
        }

        System.out.println(maxTime);
    }
}
