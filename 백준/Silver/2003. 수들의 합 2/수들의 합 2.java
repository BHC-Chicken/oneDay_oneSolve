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

        int[] arr = new int[n + 1];
        arr[0] = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }

        int left = 0;
        int right = 1;
        int result = 0;

        while (left != n) {
            if (arr[right] - arr[left] == m) {
                result++;
                right++;
            } else if (arr[right] - arr[left] <= m) {
                right++;
            } else {
                left++;
            }
            if (right > n) {
                break;
            }
        }

        System.out.println(result);
    }
}
