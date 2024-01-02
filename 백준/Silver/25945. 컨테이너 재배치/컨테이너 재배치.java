import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int space = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[space];
        int sum = 0;

        for (int i = 0; i < space; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sum += num;
        }

        int avg = sum / space;

        int min = 0;
        int max = 0;

        for (int i = 0; i < space; i++) {
            int num = arr[i];

            if (num > avg + 1) {
                max += (num - (avg + 1));
            } else if (num < avg) {
                min += (avg - num);
            }
        }

        System.out.println(Math.max(max, min));
    }
}
