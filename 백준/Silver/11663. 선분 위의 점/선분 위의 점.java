import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = n - 1;

            int result = m;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] >= x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            result -= left;
            right = n - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] > y) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            result -= (m -left);

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
