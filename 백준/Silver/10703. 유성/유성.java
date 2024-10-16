import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int getMinDistance(int m, int n, char[][] map) {
        int minDistance = 3001;

        for (int i = 0; i < m; i++) {
            int endX = -1;
            int startHashTag = 0;
            for (int j = 0; j < n - 1; j++) {
                if (map[j + 1][i] == '.' && map[j][i] == 'X') {
                    endX = j;
                }

                if (map[j][i] == '#') {
                    startHashTag = j;
                    break;
                }
            }

            if (startHashTag == 0) {
                startHashTag = (n - 1);
            }

            if (endX != -1) {
                minDistance = Math.min(minDistance, startHashTag - endX - 1);
            }
        }
        return minDistance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        char[][] result = new char[n][m];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = word.charAt(j);

                if (map[i][j] != '#') {
                    result[i][j] = '.';
                } else {
                    result[i][j] = map[i][j];
                }
            }
        }

        int minDistance = getMinDistance(m, n, map);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[j][i] == 'X') {
                    result[j + minDistance][i] = 'X';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
