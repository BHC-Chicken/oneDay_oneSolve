import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        for (int a = Integer.parseInt(num); a > 0; a--) {
            if (!String.valueOf(a).contains("0") && !String.valueOf(a).contains("1") && !String.valueOf(a).contains("2")
                    && !String.valueOf(a).contains("3") && !String.valueOf(a).contains("5") && !String.valueOf(a)
                    .contains("6") && !String.valueOf(a).contains("8") && !String.valueOf(a).contains("9")) {
                System.out.println(a);
                break;

            }
        }
    }
}