import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long binary(long num) {
        long start = 0;
        long end = num;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (num <= Math.pow(mid, 2)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long num = Long.parseLong(br.readLine());

        System.out.println(binary(num));
    }
}
