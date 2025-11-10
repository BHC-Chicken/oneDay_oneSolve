import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[] factorial = new long[21];
    static boolean[] visited = new boolean[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int problemType = Integer.parseInt(st.nextToken());

        if (problemType == 1) {
            long k = Long.parseLong(st.nextToken());
            k--;

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (visited[j]) {
                        continue;
                    }

                    if (k < factorial[n - 1 - i]) {
                        sb.append(j).append(" ");
                        visited[j] = true;

                        break;
                    } else {
                        k -= factorial[n - 1 - i];
                    }
                }
            }

            System.out.println(sb.toString().trim());

        } else {
            int[] permutation = new int[n];
            for (int i = 0; i < n; i++) {
                permutation[i] = Integer.parseInt(st.nextToken());
            }

            long rank = 0;

            for (int i = 0; i < n; i++) {
                int currentNum = permutation[i];

                for (int j = 1; j < currentNum; j++) {
                    if (!visited[j]) {
                        rank += factorial[n - 1 - i];
                    }
                }
                visited[currentNum] = true;
            }

            System.out.println(rank + 1);
        }
    }
}
