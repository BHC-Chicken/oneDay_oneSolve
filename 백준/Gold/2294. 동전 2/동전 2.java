import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        int[] dp = new int[k + 1];

        int initValue = 1000001;
        for (int i = 0; i <= k; i++) {
            dp[i] = initValue;
        }

        dp[0] = 0;

        for (int i : set) {
            for (int j = i; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - i] + 1);
            }
        }

        if (dp[k] == initValue) {
            System.out.println(-1);

            return;
        }

        System.out.println(dp[k]);
    }
}
