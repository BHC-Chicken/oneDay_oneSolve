import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int result = Integer.MAX_VALUE;
    static int start;
    static int goal;

    static void dfs(long num, int count) {
        if (num == goal) {
            result = Math.min(count, result);

            return;
        }

        if (num > goal) {
            return;
        }

        dfs(num * 2, count + 1);
        dfs(num * 10 + 1, count + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");

        start = Integer.parseInt(numbers[0]);
        goal = Integer.parseInt(numbers[1]);

        dfs(start, 1);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);

            return;
        }

        System.out.println(result);
    }
}
