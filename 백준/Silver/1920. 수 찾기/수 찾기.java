import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int loop = Integer.parseInt(br.readLine());

        int[] arr = new int[loop];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < loop; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int num = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            sb.append(binary(arr, Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.println(sb);

    }

    public static int binary(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}