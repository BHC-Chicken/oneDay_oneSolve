import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int a = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();
        int sum = 0;
        int result = 0;
        int count = 0;

        if (num.length() == 1) {
            System.out.println(count);
            if (Integer.parseInt(num) % 3 != 0 || Integer.parseInt(num) == 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
            return;
        }

        while (true) {
            if (num.length() == 1) {
                break;
            }
            sum = 0;
            for (int i = 0; i < num.length(); i++) {
                sum += Integer.parseInt(String.valueOf(num.charAt(i)));
            }
            count++;
            num = String.valueOf(sum);
        }

        System.out.println(count);
        if (sum % 3 != 0 || sum == 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
