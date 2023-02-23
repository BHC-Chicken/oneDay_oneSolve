import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int [] arr;
    static int loop;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        loop = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long total = 0;
        arr = new int[loop];

        for (int i = 0; i < loop; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < loop - 1; i++) {
            total += binarySearch(i) - i;
        }

        System.out.println(total);
    }

    public static int binarySearch(int target) {
        int left = target + 1;
        int ans = left;
        int right = arr.length - 1;
        int mid = 0;

        if (arr[target] * 10 < arr[left] * 9) {
            return target;
        }

        while (left <= right) {
            mid = left + (right - left) / 2;
            if ((arr[target] * 10 >= arr[mid] * 9) && (arr[target] <= arr[mid])) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
