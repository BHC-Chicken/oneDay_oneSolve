import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());
        int [] arr = new int[100001];
        int sum = 0;
        int count = 0;

        while (loop-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                count ++;
                sum += num;
                arr[count] = num;
            } else {
                sum -= arr[count];
                count--;
            }
        }

        System.out.println(sum);
    }
}