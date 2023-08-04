import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int team = Integer.parseInt(st.nextToken());
        int people = team * Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[num];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < num; i++) {
            people -= arr[i];

            if (people <= 0) {
                sb.append(i + 1);
                break;
            }
        }

        if (people > 0) {
            sb.append("STRESS");
        }


        System.out.println(sb);
    }
}
