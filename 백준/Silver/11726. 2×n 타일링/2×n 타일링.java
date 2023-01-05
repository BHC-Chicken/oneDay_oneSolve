import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = Long.parseLong(br.readLine());
        long[] arr = new long[1001];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;

        for (int i = 4; i <= num; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }

        long result = arr[(int) num];

        System.out.println(result);
    }
}