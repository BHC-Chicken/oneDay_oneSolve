import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < col; j++) {
                if (split[j].equals("W")) {
                    map[i][j] = true;
                } else {
                    map[i][j] = false;
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < row - 7; i++) {
            for (int j = 0; j < col - 7; j++) {
                int count = 0;
                boolean start = map[i][j];

                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        if (map[k][l] != start) {
                            count++;
                        }

                        start = !start;
                    }

                    start = !start;
                }
                count = Math.min(count, 64 - count);
                result = Math.min(count, result);
            }
        }

        System.out.println(result);
    }
}
