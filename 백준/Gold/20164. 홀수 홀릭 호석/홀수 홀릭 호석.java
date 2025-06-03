import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static void dfs(int n, int total) {
        if (n < 10) {
            min = Math.min(min, total);
            max = Math.max(max, total);

            return;
        }

        if (n < 100) {
            int sum = (n / 10) + (n % 10);
            dfs(sum, total + getOdd(sum));

            return;
        }

        String str = String.valueOf(n);
        int length = str.length();

        for (int i = 0; i <= length - 3; i++) {
            for (int j = i + 1; j <= length - 2; j++) {
                String word1 = str.substring(0, i + 1);
                String word2 = str.substring(i + 1, j + 1);
                String word3 = str.substring(j + 1, length);

                int sum = Integer.parseInt(word1) + Integer.parseInt(word2) + Integer.parseInt(word3);
                dfs(sum, total + getOdd(sum));
            }
        }
    }

    private static int getOdd(int sum) {
        int count = 0;

        while (sum > 0) {
            int now = sum % 10;

            if ((now % 2) == 1) {
                count++;
            }

            sum /= 10;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dfs(n, getOdd(n));

        System.out.println(min + " " + max);
    }
}
