import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(br.readLine());
        long result = 0;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            long sum = 0;

            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum > k) {
                    result += (n - j);

                    break;
                }
            }
        }

        System.out.println(result);
    }
}
