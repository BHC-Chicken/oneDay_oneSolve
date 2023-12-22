import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int limit = 0;
        int[] arr = new int[20];

        if (x == 0 && y == 0) {
            System.out.println(1);

            return;
        }

        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] * 3;
            if (arr[i] > Math.max(x, y)) {
                limit = i - 1;
                break;
            }
        }

        for (int i = limit; i >= 0; i--) {
            if (x > y) {
                x -= arr[i];
            } else {
                y -= arr[i];
            }
        }

        if (x == 0 && y == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}