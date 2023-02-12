import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            int people = Integer.parseInt(br.readLine());

            int[] arr = new int[people + 1];
            int count = 1;
            int min = 0;

            for (int j = 0; j < people; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    min = b;
                }
                arr[a] = b;
            }
            for (int j = 2; j <= people; j++) {
                if (min > arr[j]) {
                    count++;
                    min = arr[j];
                }
            }
            System.out.println(count);
        }
    }
}