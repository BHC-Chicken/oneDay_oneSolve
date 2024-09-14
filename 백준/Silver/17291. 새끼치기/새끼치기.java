import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] bugs = new int[21];

        bugs[1] = 1;
        bugs[2] = 2;
        bugs[3] = 4;
        bugs[4] = 7;

        for (int i = 5; i <= n; i++) {
            if (i % 2 == 0) {
                bugs[i] = bugs[i - 1] * 2 - (bugs[i - 4] + bugs[i - 5]);
            } else {
                bugs[i] = bugs[i - 1] * 2;
            }
        }

        System.out.println(bugs[n]);
    }
}
