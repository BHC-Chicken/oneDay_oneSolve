import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        String street = br.readLine();
        int count = 0;

        for (int i = 0; i < num - 1; i++) {
            if (street.charAt(i) == 'E' && street.charAt(i + 1) == 'W') {
                count++;
                i++;
            }
        }

        sb.append(count);

        System.out.println(sb);
    }
}
