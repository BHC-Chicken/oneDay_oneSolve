import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int city = Integer.parseInt(br.readLine());
        long sum = 0;

        long[] load = new long[city];
        long[] oil = new long[city];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < city - 1; i++) {
            load[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < city - 1; i++) {
            oil[i] = Long.parseLong(st.nextToken());
        }

        long min = oil[0];

        for (int i = 0; i < city - 1; i++) {
            if (oil[i] < min) {
                min = oil[i];
            }

            sum += min * load[i];
        }
        System.out.println(sum);
    }
}