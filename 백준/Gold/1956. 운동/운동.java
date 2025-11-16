import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[][] distance = new int[v + 1][v + 1];

        int maxLength = 100000000;

        for (int i = 1; i <= v; i++) {
            Arrays.fill(distance[i], maxLength);
        }

        for (int i = 0; i < e; i++) {
            st= new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            distance[a][b] = c;
        }

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        int result = maxLength;

        for (int i = 1; i <= v; i++) {
            result = Math.min(result, distance[i][i]);
        }

        if (result == maxLength) {
            System.out.println(-1);

            return;
        }

        System.out.println(result);
    }
}
