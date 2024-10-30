import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited = new boolean[2000001];
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        dfs(0,0);

        while (visited[answer]) {
            answer++;
        }

        System.out.println(answer);
    }

    static void dfs(int index, int sum) {
        if (index == n) {
            visited[sum] = true;
        } else {
            dfs(index + 1, sum + arr[index]);
            dfs(index + 1, sum);
        }
    }
}
