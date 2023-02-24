import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        if (num == 3 && arr[2] < (arr[1] + arr[0])) {
            System.out.println(arr[2] + arr[1] + arr[0]);
            return;
        }

        for (int i = num - 1; i > 1; i--) {
            long a = arr[i];
            for (int j = i - 1; j >= 1; j--) {
                long b = arr[j];
                long c = arr[j - 1];

                if (a < (b + c)) {
                    System.out.println(a + b + c);

                    return;
                }
            }
        }

        System.out.println(-1);

    }
}
