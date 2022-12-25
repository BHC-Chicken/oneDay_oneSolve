import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int loop = Integer.parseInt(st.nextToken());
        int count = 0;

        int[] arr = new int[loop];
        int num = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < loop; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int a = 0;
        for (int i = 0; i < loop; i++) {
            int sum = 0;
            for (int temp = a; temp < loop; temp++) {
                sum += arr[temp];
                if (sum == num) {
                    count++;
                    a++;
                    break;
                }
                if (sum > num) {
                    a++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}