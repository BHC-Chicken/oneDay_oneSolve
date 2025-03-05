import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        boolean isNum = false;

        for (int i = 0; i < 3; i++) {
            String value = br.readLine();

            if (isNum) {
                num += 1;

                continue;
            }

            if (Character.isDigit(value.charAt(0))) {
                isNum = true;
                num = Integer.parseInt(value);
            }
        }
        num += 1;

        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (num % 3 == 0) {
            System.out.println("Fizz");
        } else if (num % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(num);
        }
    }
}
