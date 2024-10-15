import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] map = new int[y];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < y; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < y - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(left, map[j]);
            }

            for (int j = i + 1; j < y; j++) {
                right = Math.max(right, map[j]);
            }

            if (map[i] < left && map[i] < right) {
                result += Math.min(left - map[i], right - map[i]);
            }
        }

        System.out.println(result);
    }
}
