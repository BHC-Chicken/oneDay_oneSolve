import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int depth = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[depth + 1];
        int min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= depth; i++) {
            int num = Integer.parseInt(st.nextToken());
            min = Math.min(min, num);

            arr[i] = min;
        }

        int index = depth;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            int num = Integer.parseInt(st.nextToken());

            for (int j = index; j >= 1; j--) {
                if (num <= arr[j]) {
                    index = j - 1;
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.println(0);

                return;
            }
        }

        System.out.println(index + 1);
    }
}
