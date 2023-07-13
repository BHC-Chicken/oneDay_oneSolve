import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        boolean flag = true;
        int[] arr = new int[num];
        int answer = 0;

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        while (flag) {
            for (int i = 0; i < num - 1; i++) {
                int temp = 0;
                if (arr[i] >= arr[i + 1]) {
                    temp = (arr[i] - arr[i + 1]) + 1;
                    answer += temp;
                    arr[i] -= temp;
                }
            }

            for (int i = 0; i < num - 1; i++) {
                if (arr[i] >= arr[i + 1]) {
                    break;
                } else if (i == num - 2 && arr[i] < arr[i + 1]) {
                    flag = false;
                }
            }
        }

        System.out.println(answer);
    }
}
