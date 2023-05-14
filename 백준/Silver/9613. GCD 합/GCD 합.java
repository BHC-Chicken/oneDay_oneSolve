import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tCase = Integer.parseInt(st.nextToken());
            long sum = 0;
            int[] arr = new int[tCase];

            for (int j = 0; j < tCase; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < tCase - 1; j++) {
                for (int k = j + 1; k < tCase; k++) {
                    sum += gcd(arr[j], arr[k]);
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}