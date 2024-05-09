import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n;
    static int k;
    static int answer;
    static int[] arr;
    static boolean[] visit;

    static void dfs(int sum, int index) {
        if (sum == k) {
            answer++;

            return;
        }

        if (index >= n || sum > k) {
            return;
        }

        dfs(sum + arr[index], index + 1);
        dfs(sum, index + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n];
            visit = new boolean[n];

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            answer = 0;
            dfs(0, 0);

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
