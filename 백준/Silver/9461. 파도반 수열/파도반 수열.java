import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int loop = Integer.parseInt(br.readLine());
        long[] arr = new long[101];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 0; i < loop; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = 3; j <= num; j++) {
                arr[j] = arr[j - 2] + arr[j - 3];
            }
            sb.append(arr[num]).append("\n");
        }

        System.out.println(sb);

    }
}
