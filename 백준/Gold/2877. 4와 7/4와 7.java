import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int tempSum = 0;
        int length = 1;

        StringBuilder result = new StringBuilder();

        while (true) {
            tempSum += (int) Math.pow(2, length);

            if (tempSum < k) {
                length++;
            } else {

                break;
            }
        }

        int pow = (int) Math.pow(2, length);
        int count = k - (tempSum - pow);

        for (int i = 0; i < length - 1; i++) {
            int temp = pow / 2;

            if (temp >= count) {
                result.append(4);
            } else {
                result.append(7);
                count -= temp;
            }

            pow /= 2;
        }

        if (count == 1) {
            result.append(4);
        } else {
            result.append(7);
        }

        System.out.println(result);
    }
}
