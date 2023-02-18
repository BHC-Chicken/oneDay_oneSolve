import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        long[] arr = new long[100];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= num; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        System.out.println(arr[num]);
    }
}
