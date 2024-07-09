import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int block;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        block = Integer.parseInt(st.nextToken());

        int size = n * m;
        map = new int[size];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int timeResult = Integer.MAX_VALUE;
        int heightResult = 0;

        int index = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[index++] = num;

                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }

        for (int i = min; i <= max; i++) {
            int temp = block;
            int time = 0;

            for (int j = 0; j < size; j++) {
                if (map[j] > i) {
                    temp += map[j] - i;
                    time += (2 * (map[j] - i));
                } else if (map[j] < i) {
                    temp += (map[j] - i);
                    time += (i - map[j]);
                }
            }

            if (temp < 0) {
                continue;
            }

            if (time <= timeResult) {
                timeResult = time;
                heightResult = i;
            }
        }

        sb.append(timeResult).append(" ").append(heightResult);

        System.out.println(sb);
    }
}