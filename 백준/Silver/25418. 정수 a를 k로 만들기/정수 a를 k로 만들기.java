import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;

        while (a != k) {
            if (k % 2 == 0 && k / 2 >= a) {
                k /= 2;
            } else {
                k -= 1;
            }

            count++;
        }

        System.out.println(count);
    }
}