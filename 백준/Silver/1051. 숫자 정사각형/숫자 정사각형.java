import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;

    static boolean search(int size, int n, int m) {
        return map[n][m] == map[n + size][m] && map[n][m] == map[n][m + size] && map[n][m] == map[n + size][m + size];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];


        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        int minSize = Math.min(n, m);

        while (minSize != 1) {
            for (int i = 0; i <= n - minSize; i++) {
                for (int j = 0; j <= m - minSize; j++) {
                    if (search(minSize -1, i, j)) {
                        System.out.println(minSize * minSize);

                        return;
                    }
                }
            }

            minSize -= 1;
        }

        System.out.println(minSize * minSize);
    }
}
