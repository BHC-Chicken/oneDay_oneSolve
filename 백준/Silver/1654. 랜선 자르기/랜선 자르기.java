import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] len = new int[k];

        long left = 0;
        long right = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());

            len[i] = num;
            right = Math.max(right, num);
        }

        right++;

        while (left < right) {
            long count = 0;
            long mid = (left + right) / 2;

            for (int i = 0; i < k; i++) {
                count += len[i] / mid;
            }

            if (count < n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left - 1);
    }
}
