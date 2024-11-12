import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i : result) {
                sb.append(i).append(" ");
            }

            sb.append("\n");

            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                dfs(i, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] numbers = br.readLine().split(" ");

            if (Integer.parseInt(numbers[0]) == 0) {
                break;
            }

            result = new int[6];
            arr = new int[Integer.parseInt(numbers[0])];
            visited = new boolean[Integer.parseInt(numbers[0])];

            int loop = Integer.parseInt(numbers[0]);

            for (int i = 1; i <= loop; i++) {
                arr[i - 1] = Integer.parseInt(numbers[i]);
            }

            dfs(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
