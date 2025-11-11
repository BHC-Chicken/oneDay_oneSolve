import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long totalSum = 0;
        int maxLength = 0;

        int[] arr = new int[s];

        for (int i = 0; i < s; i++) {
            int num = Integer.parseInt(br.readLine());

            arr[i] = num;
            totalSum += num;
            maxLength = Math.max(maxLength, num);
        }

        long left = 1;
        long right = maxLength;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long count = 0;
            for (int i = 0; i < s; i++) {
                count += (arr[i] / mid);
            }

            if (count >= c) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        result = totalSum - (result * c);

        System.out.println(result);
    }
}
