import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int value = Integer.parseInt(br.readLine());
        int[] sum = new int[value + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        sum[0] = 0;
        for (int i = 1; i <= value; i++) {
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];
        }

        value = Integer.parseInt(br.readLine());

        for (int i = 0; i < value; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(sum[m] - sum[n - 1]).append("\n");
        }

        System.out.println(sb);
    }
}
