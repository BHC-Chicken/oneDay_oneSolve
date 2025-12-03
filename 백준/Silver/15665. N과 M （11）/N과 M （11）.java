import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();


    static void dfs(int depth) {
        if (depth == m) {
            for (int i : result) {
                sb.append(i).append(" ");
            }

            sb.append("\n");

            return;
        }

        for (int j : arr) {
            result[depth] = j;
            dfs(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        int[] temp = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        arr = Arrays.stream(temp)
                .distinct()
                .sorted()
                .toArray();

        result = new int[m];

        dfs(0);

        System.out.println(sb);
    }
}
