import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();
        int r = 0;
        int b = 0;
        char start = '\0';

        for (char c : arr) {
            if (c != start) {
                if (c == 'B') {
                    b++;
                } else {
                    r++;
                }
                start = c;
            }
        }

        System.out.println(Math.min(r, b) + 1);
    }
}
