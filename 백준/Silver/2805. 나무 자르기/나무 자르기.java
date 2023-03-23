import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int value = Integer.parseInt(st.nextToken());
        long max = 0;
        int[] arr= new int[num];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        max++;

        long min = 0;
        long mid = 0;

        while (min < max) {
            mid = (min + max) / 2;
            long count = 0;

            for (int j : arr) {
                if (j >= mid) {
                    count += (j - mid);
                }
            }

            if (count < value) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);

    }

}