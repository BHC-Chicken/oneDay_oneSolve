import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = m; i <= n; i++) {
            boolean flag = true;
            if (i == 0 || i == 1) {
                continue;
            }
            for (int a = 2; a <= (int) Math.sqrt(i); a++) {
                if (i % a == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (i < min) {
                    min = i;
                }
                sum += i;
            }
        }

        if (sum == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(sum);
        System.out.println(min);
    }
}