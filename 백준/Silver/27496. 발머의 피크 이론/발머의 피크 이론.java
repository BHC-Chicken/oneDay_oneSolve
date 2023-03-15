import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;
        int timeCount = 1;

        int[] arr = new int[n];
        int[] sum = new int[n];
        int[] temp = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sum[0] = arr[0];
        temp[0] = arr[0];

        if (129 <= sum[0] && sum[0] <= 138) {
            count++;
        }

        for (int i = 1; i < n; i++) {
            int c = arr[i];
            temp[i] = c;
            sum[i] = sum[i - 1] + c;
            if (timeCount >= m) {
                sum[i] = sum[i] - temp[i - m];
            }
            if (129 <= sum[i] && sum[i] <= 138) {
                count++;
            }
            timeCount++;
        }

        System.out.println(count);
    }
}
