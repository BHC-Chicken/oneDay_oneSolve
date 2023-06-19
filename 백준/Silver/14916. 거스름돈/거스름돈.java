import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = Integer.parseInt(br.readLine());

        int count = 0;

        while (money > 0) {
            if (money % 5 == 0) {
                count = money / 5 + count;
                break;
            }
            money -= 2;
            count++;
        }

        if (money < 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}
