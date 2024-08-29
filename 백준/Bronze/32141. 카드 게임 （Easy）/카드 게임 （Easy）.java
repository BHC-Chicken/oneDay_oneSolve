import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            h -= num;
            count++;

            if (h <= 0) {
                break;
            }
        }

        if (h > 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}