import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;

        boolean[] visit = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                if (!visit[j]) {
                    count++;
                    visit[j] = true;
                }
                if (count == k) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}