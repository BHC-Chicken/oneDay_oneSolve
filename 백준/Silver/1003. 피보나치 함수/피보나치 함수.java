import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num + 10];
            arr[0] = 0;
            arr[1] = 1;

            if (num == 0) {
                System.out.println(1 + " " + 0);
                continue;
            }

            if (num == 1) {
                System.out.println(0 + " " + 1);
                continue;
            }

            for (int j = 2; j <= num; j++) {
                arr[j] = arr[j - 1] + arr[j - 2];
            }
            System.out.println(arr[num - 1] + " " + arr[num]);
        }
    }

}