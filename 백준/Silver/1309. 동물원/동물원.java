import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][3];
        map[1][0] = 1;
        map[1][1] = 1;
        map[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            map[i][0] = (map[i - 1][0] + map[i - 1][1] + map[i - 1][2]) % 9901;
            map[i][1] = (map[i - 1][0] + map[i - 1][2]) % 9901;
            map[i][2] = (map[i - 1][0] + map[i - 1][1]) % 9901;
        }

        int result = (map[n][0] + map[n][1] + map[n][2]) % 9901;

        System.out.println(result);
    }
}
