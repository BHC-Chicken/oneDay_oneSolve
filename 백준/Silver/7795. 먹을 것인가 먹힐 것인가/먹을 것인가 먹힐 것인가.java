import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr1;
    static int[] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            arr1 = new int[n];
            arr2 = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr1[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr2[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            int count = 0;

            for (int j = 0; j < n; j++) {
                int num = arr1[j];
                for (int k = 0; k < m; k++) {
                    if (num > arr2[k]) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}