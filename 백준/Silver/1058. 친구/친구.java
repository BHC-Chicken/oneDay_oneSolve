import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    map[i][j] = 0;
                } else if (word.charAt(j) == 'Y') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 999999999;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] > map[j][i] + map[i][k]) {
                        map[j][k] = map[j][i] + map[i][k];
                    }
                }
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && map[i][j] <= 2) {
                    count++;
                }
            }

            result = Math.max(result, count);
        }

        System.out.println(result);
    }
}
