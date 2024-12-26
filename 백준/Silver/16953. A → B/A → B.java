import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int result = Integer.MAX_VALUE;
    static String start;
    static String goal;

    static void dfs(String num, int count) {
        if (num.equals(goal)) {
            result = Math.min(count, result);

            return;
        }

        if (Long.parseLong(num) > Long.parseLong(goal)) {
            return;
        }

        dfs(String.valueOf(Long.parseLong(num) * 2), count + 1);
        dfs(num + "1", count + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");

        start = numbers[0];
        goal = numbers[1];

        dfs(start, 1);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);

            return;
        }

        System.out.println(result);
    }
}
