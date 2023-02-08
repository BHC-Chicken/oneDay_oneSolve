import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[m];

        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int maxTotal = 0;
        int maxValue = 0;

        for (int i = 0; i < m; i++) {
            int temp = 0;
            for (int j = 0; j < i + 1; j++) {
                if (j >= n) {
                    break;
                }
                temp += arr[i];
            }
            if (maxTotal <= temp) {
                maxTotal = temp;
                maxValue = arr[i];
            }
        }

        System.out.println(maxValue + " " + maxTotal);
    }
}