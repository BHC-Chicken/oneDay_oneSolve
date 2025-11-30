import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] price = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                price[j] = Integer.parseInt(st.nextToken());
            }

            long maxProfit = 0;
            int maxPrice = price[n - 1];

            for (int j = n - 2; j >= 0; j--) {
                if (price[j] > maxPrice) {
                    maxPrice = price[j];
                } else {
                    maxProfit += (maxPrice - price[j]);
                }
            }

            sb.append(maxProfit).append("\n");
        }

        System.out.println(sb);
    }
}
