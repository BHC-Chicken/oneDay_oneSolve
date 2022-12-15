import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int a = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());


        while (st.hasMoreTokens()) {
            boolean isPrime = true;
            int prime = Integer.parseInt(st.nextToken());

            if (prime == 1) {
                continue;
            }

            for (int i = 2; i <= Math.sqrt(prime); i++) {
                if (prime % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
            }
        }

        System.out.println(count);
    }
}
