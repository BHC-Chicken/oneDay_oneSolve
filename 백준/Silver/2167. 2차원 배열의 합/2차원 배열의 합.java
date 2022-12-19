import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int a = 0; a < n; a++) {
            st = new StringTokenizer(br.readLine());
            for (int b = 0; b < m; b++) {
                arr[a][b] = Integer.parseInt(st.nextToken());
            }
        }

        int loop = Integer.parseInt(br.readLine());

        while (loop-- > 0) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for (int i = a; i < c; i++) {
                for (int x = b; x < d; x++) {
                    sum += arr[i][x];
                }
            }

            System.out.println(sum);
        }
    }
}