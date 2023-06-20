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
        double[] arr = new double[loop];
        double sum = 0;

        for (int i = 0; i < loop; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < loop - 1; i++) {
            sum += (arr[i] / 2);
        }

        sum += arr[arr.length - 1];

        if ((int) sum == sum) {
            System.out.println((int) sum);
        } else {
            System.out.println(sum);
        }
    }
}
