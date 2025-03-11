import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int c;
    static int[] arr;

    static boolean isPossible(int distance) {
        int start = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= start + distance) {
                count++;
                start = arr[i];
            }
        }

        return count >= c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = -1;
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[n - 1] - arr[0];

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {
                left = mid + 1;

                result = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
