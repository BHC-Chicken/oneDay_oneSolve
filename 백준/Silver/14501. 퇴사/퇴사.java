import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int day = Integer.parseInt(br.readLine());
        int[] t = new int[day + 15];
        int[] p = new int[day + 15];
        int[] dp = new int[day + 15];
        int max = 0;

        for (int i = 0; i < day; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= day; i++) {
            dp[i] = Math.max(dp[i], max);
            dp[t[i] + i] = Math.max(dp[t[i] + i], p[i] + dp[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}