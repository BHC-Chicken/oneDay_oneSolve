import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0;

        while (num != 0) {
            if (String.valueOf(num).contains("1")) {
                if (num == 1) {
                    num = 0;
                }
                num = Integer.parseInt(String.valueOf(num).replaceFirst("1", ""));
            } else {
                num -= 1;
            }
            count++;
        }

        System.out.println(count);
    }
}
