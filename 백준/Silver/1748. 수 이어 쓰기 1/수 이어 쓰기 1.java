import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder numLength = new StringBuilder();
        String num = br.readLine();
        long count = 0;

        if (num.length() > 1) {
            sb.append(9);
            numLength.append(1);
            for (int i = 0; i < num.length() - 1; i++) {
                count += Long.parseLong(sb.toString()) * (i + 1);
                sb.append(0);
                numLength.append(0);
            }
            long value = ((Long.parseLong(num) - Long.parseLong(numLength.toString())) + 1) * num.length();

            count += value;
        } else {
            count += Long.parseLong(num);
        }

        System.out.println(count);
    }
}