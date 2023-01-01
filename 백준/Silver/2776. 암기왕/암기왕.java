import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int a = 0; a < n; a++) {
                arr[a] = Integer.parseInt(st.nextToken());
            }

            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            Arrays.sort(arr);

            while (st.hasMoreTokens()) {
                if (binary(Integer.parseInt(st.nextToken()), arr)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    public static boolean binary(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}