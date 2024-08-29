import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] map = new int[3];
        boolean flag = false;
        int evenCount = 0;
        int result = 1;

        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num % 2 == 0) {
                evenCount++;
                flag = true;
            }
            map[i] = num;
        }

        if (!flag || evenCount == 3) {
            for (int i = 0; i < 3; i++) {
                result *= map[i];
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (map[i] % 2 == 1) {
                    result *= map[i];
                }
            }
        }

        System.out.println(result);
    }
}