import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] prime = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        get_prime();

        int test_case = Integer.parseInt(br.readLine());

        while (test_case-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int first = n / 2;
            int second = n / 2;

            while (true) {
                if (!prime[first] && !prime[second]) {
                    sb.append(first).append(" ").append(second).append("\n");
                    break;
                }
                first--;
                second++;
            }
        }

        System.out.println(sb);
    }

    public static void get_prime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) {
                continue;
            }
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}