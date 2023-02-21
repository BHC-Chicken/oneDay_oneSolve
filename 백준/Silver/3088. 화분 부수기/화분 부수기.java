import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];
        int count = 0;
        StringTokenizer st;

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (arr[a] == 0 && arr[b] == 0 && arr[c] == 0) {
                arr[a]++;
                arr[b]++;
                arr[c]++;
                count++;
            } else {
                arr[a]++;
                arr[b]++;
                arr[c]++;
            }
        }

        System.out.println(count);

    }
}

