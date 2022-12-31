import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int people = Integer.parseInt(st.nextToken());
            double sum = 0;

            int[] arr = new int[people];

            for (int a = 0; a < people; a++) {
                arr[a] = Integer.parseInt(st.nextToken());
                sum += arr[a];
            }

            int avg = (int) (sum / people);
            double count = 0;

            for (int a = 0; a < people; a++) {
                if (arr[a] > avg) {
                    count++;
                }
            }

            double result = (count / people) * 100;

            sb.append(String.format("%.3f", result)).append("%").append("\n");
        }

        System.out.println(sb);
    }
}