import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int max = 0;
        int xCount = 0;

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        int index = 2;

        arr[0] = 0;
        arr[1] = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            arr[index] = arr[index - 1] + Integer.parseInt(st.nextToken());
            index++;
        }

        if (x == 1) {
            max = arr[1];
            xCount = 1;
        }

        for (int i = x; i <= n; i++) {
            int temp = arr[i] - arr[i - x];

            if (temp > max) {
                max = temp;
                xCount = 1;
            } else if (temp == max) {
                xCount++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");

            return;
        }

        String sb = max + "\n" + xCount;

        System.out.println(sb);
    }
}
