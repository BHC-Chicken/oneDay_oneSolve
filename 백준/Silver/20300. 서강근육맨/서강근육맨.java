import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[loop];

        for (int i = 0; i < loop; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long min = 0;

        if (arr.length % 2 == 0) {
            int size = arr.length - 1;
            int minSize = 0;
            while (minSize < size) {
                long temp = arr[minSize] + arr[size];
                min = Math.max(min, temp);

                minSize++;
                size--;
            }
        } else {
            int size = arr.length - 2;
            int minSize = 0;
            min = arr[arr.length - 1];

            while (minSize < size) {
                long temp = arr[minSize] + arr[size];
                min = Math.max(min, temp);

                minSize++;
                size--;
            }
        }

        System.out.println(min);
    }
}
