import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int temp = Integer.parseInt(br.readLine());
            arr[i] = temp;
            sum += temp;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    Arrays.sort(arr);

                    for (int a = 2; a < 9; a++) {
                        sb.append(arr[a]).append("\n");
                    }

                    System.out.println(sb);

                    return;
                }
            }
        }
    }
}