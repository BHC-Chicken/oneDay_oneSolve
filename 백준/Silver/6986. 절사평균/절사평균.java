import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        double avg1 = 0;
        double avg2 = 0;

        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = m; i < n - m; i++) {
            avg1 += arr[i];
        }

        avg1 /= (n - (m * 2));

        double temp1 = arr[m];
        double temp2 = arr[arr.length - m - 1];

        for (int i = 0; i < m; i++) {
            arr[i] = temp1;
        }

        for (int i = arr.length - 1; i >= arr.length - m; i--) {
            arr[i] = temp2;
        }

        for (int i = 0; i < arr.length; i++) {
            avg2 += arr[i];
        }

        avg2 /= n;

        avg1 = (Math.round(avg1*100)/100.0);
        avg2 = (Math.round(avg2*100)/100.0);

        sb.append(String.format("%.2f", avg1)).append("\n").append(String.format("%.2f",avg2));

        System.out.println(sb);
    }
}