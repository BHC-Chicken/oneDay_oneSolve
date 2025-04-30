import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[100001];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 2;
        arr[5] = 1;
        arr[6] = 2;
        arr[7] = 1;

        for (int i = 8; i <= n; i++) {
            arr[i] = Math.min(arr[i - 1], Math.min(arr[i - 2], Math.min(arr[i - 5], arr[i - 7]))) + 1;
        }

        System.out.println(arr[n]);
    }
}
