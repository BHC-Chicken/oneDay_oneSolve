import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int num;
    static int[][] arr;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        int index = 0;

        int curX = 0;
        int curY = 0;

        arr[curX][curY] = n * n;

        while (true) {
            int nx = curX + dx[index];
            int ny = curY + dy[index];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == 0) {
                arr[nx][ny] = arr[curX][curY] - 1;

                if (arr[nx][ny] == 1) {
                    break;
                }

                curX = nx;
                curY = ny;
            } else {
                index++;

                if (index >= 4) {
                    index = 0;
                }
            }
        }

        int answerX = 0;
        int answerY = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
                if (arr[i][j] == num) {
                    answerX = i + 1;
                    answerY = j + 1;
                }
            }
            sb.append("\n");
        }

        sb.append(answerX).append(" ").append(answerY);

        System.out.println(sb);
    }
}
