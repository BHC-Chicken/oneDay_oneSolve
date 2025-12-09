import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arrSize = 1000001;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] map = new int[arrSize];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            map[x] = g;
        }

        for (int i = 1; i < arrSize; i++) {
            map[i] += map[i - 1];
        }

        int windowSize = 2 * k + 1;

        if (windowSize >= arrSize) {
            System.out.println(map[arrSize - 1]);

            return;
        }

        int result = map[windowSize - 1];

        for (int i = windowSize; i < arrSize; i++) {
            result = Math.max(result, map[i] - map[i - windowSize]);
        }

        System.out.println(result);
    }
}
