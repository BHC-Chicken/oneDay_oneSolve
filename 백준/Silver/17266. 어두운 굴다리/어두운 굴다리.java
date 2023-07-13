import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean flag = true;

            int point = 0;
            for (int j : arr) {
                if (j - mid <= point) {
                    point = j + mid;
                } else {
                    flag = false;
                }
            }

            flag = n - point <= 0;

            if (flag) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }
}
