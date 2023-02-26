import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int price = 0;
        int result = 0;

        int[] arr = new int[loop];

        price = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        result = c / price;

        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            c += arr[i];
            price += b;

            int temp = c / price;
            if (temp > result) {
                result = temp;
            }
        }

        System.out.println(result);

    }
}
