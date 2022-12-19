import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long target = Long.parseLong(br.readLine());
        long num = 0;
        int temp = 0;
        for (int i = 1; ; i++) {
            if (num > target) {
                break;
            }
            num += i;
            temp++;
        }

        System.out.println(temp - 1);


    }
}