import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        long start = 0;
        long end = num;
        long min = Long.MIN_VALUE;

        while (start <= end) {
            long mid = (start + end) / 2;
            long result = (long) Math.pow(mid, 2);
            
            if (result >= num) {
                min = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(min);
    }
}