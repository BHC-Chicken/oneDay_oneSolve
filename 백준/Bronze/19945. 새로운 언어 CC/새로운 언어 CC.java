import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        if (num == 0) {
            System.out.println(1);
            return;
        }
        
        if (num < 0) {
            System.out.println(32);
            return;
        }

        while (num != 0) {
            int temp = num % 2;
            num = num / 2;
            sb.append(temp);
        }

        System.out.println(sb.length());
    }
}