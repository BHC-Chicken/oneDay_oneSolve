import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int count = 0;


        if (num < 100) {
            System.out.println(num);
            return;
        } else {
            count = 99;
        }

        if (num == 1000) {
            num = 999;
        }
        
        for (int i = 100; i <= num; i++) {
            int temp = i;

            int one = temp % 10;

            temp /= 10;
            int ten = temp % 10;

            temp /= 10;
            int hundred = temp % 10;

            if ((ten - one) == (hundred - ten)) {
                count++;
            }
        }

        System.out.println(count);

    }
}