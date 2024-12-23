import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length + 1];
        int[] dp = new int[length + 1];

        String[] input = br.readLine().split(" ");

        for (int i = 1; i <= length; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }

        dp[1] = 1;

        for (int i = 1; i <= length; i++) {
            dp[i] = arr[i];

            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i : dp) {
            result = Math.max(result, i);
        }

        System.out.println(result);
    }
}
