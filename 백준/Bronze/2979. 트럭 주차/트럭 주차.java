import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken()) * 2;
        int c = Integer.parseInt(st.nextToken()) * 3;

        int[] time = new int[101];
        int result = 0;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) - 1;

            for (int j = start; j <= end ; j++) {
                time[j]++;
            }
        }

        for (int i = 0; i < 101; i++) {
            if (time[i] == 1) {
                result += a;
            } else if (time[i] == 2) {
                result += b;
            } else if (time[i] == 3) {
                result += c;
            }
        }

        System.out.println(result);
    }
}

