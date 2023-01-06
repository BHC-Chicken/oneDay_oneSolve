import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];

        arr[0] = arr[1] = 0;
        arr[2] = arr[3] = 1;
        arr[4] = 2;

        for (int i = 5; i <= num; i++) {
            if (i % 6 == 0) {
                arr[i] = Math.min(arr[i - 1], Math.min(arr[i / 3], arr[i / 2])) + 1;
            } else if (i % 3 == 0) {
                arr[i] = Math.min(arr[i - 1], arr[i / 3]) + 1;
            } else if (i % 2 == 0) {
                arr[i] = Math.min(arr[i - 1], arr[i / 2]) + 1;
            } else {
                arr[i] = arr[i - 1] + 1;
            }
        }

        System.out.println(arr[num]);
    }
}