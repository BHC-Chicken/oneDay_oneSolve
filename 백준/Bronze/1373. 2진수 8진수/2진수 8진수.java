import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder octal = new StringBuilder();
        int[] binary = {4, 2, 1};
        String num = br.readLine();
        int count = 0;
        boolean flag = true;

        if (num.length() == 1) {
            System.out.println(num);
            return;
        }
        if (num.length() == 2) {
            int sum = Character.getNumericValue(num.charAt(1)) + (Character.getNumericValue(num.charAt(0)) * 2);
            System.out.println(sum);
            return;
        }

        if (num.length() % 3 == 0) {
            while (flag) {
                int sum = 0;
                for (int a = 0; a < 3; a++) {
                    sum += Character.getNumericValue(num.charAt(count)) * binary[a];
                    count++;
                    if (count == num.length()) {
                        flag = false;
                        break;
                    }
                }
                octal.append(sum);
            }
            System.out.println(octal);
            return;
        }

        if (num.length() % 3 == 1) {
            octal.append((Character.getNumericValue(num.charAt(0))));
            count = 1;
            while (flag) {
                int sum = 0;
                for (int a = 0; a < 3; a++) {
                    sum += Character.getNumericValue(num.charAt(count)) * binary[a];
                    count++;
                    if (count == num.length()) {
                        flag = false;
                        break;
                    }
                }
                octal.append(sum);
            }
            System.out.println(octal);
            return;
        }

        if (num.length() % 3 == 2) {
            octal.append((Character.getNumericValue(num.charAt(0)) * 2) + Character.getNumericValue(num.charAt(1)));
            count = 2;
            while (flag) {
                int sum = 0;
                for (int a = 0; a < 3; a++) {
                    sum += Character.getNumericValue(num.charAt(count)) * binary[a];
                    count++;
                    if (count == num.length()) {
                        flag = false;
                        break;
                    }
                }
                octal.append(sum);
            }
            System.out.println(octal);
        }
    }
}