import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, num, min = Integer.MAX_VALUE;
    static int[] arr, list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        num = Integer.parseInt(word);
        n = word.length();

        arr = new int[n];
        list = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(String.valueOf(word.charAt(i)));
        }
        backTracking(0);
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }

    public static void backTracking(int depth) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (int i : list) {
                sb.append(i);
            }
            int n = Integer.parseInt(sb.toString());
            if (num < n) {
                min = Math.min(min, n);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list[depth] = arr[i];
                backTracking(depth + 1);
                visited[i] = false;
            }
        }

    }
}
