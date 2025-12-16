import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int result = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int count = 0;

        for (int right = 0; right < n; right++) {
            if (arr[right] == 1) {
                count++;
            }

            while (count >= k) {
                result = Math.min(result, right - left + 1);

                if (arr[left] == 1) {
                    count--;
                }

                left++;
            }
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);

            return;
        }

        System.out.println(result);
    }
}
