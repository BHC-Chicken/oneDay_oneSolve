import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < loop; i++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] arr;
            for (int a = 1; a <= 9; a++) {
                int loop2 = Integer.parseInt(st.nextToken());
                for (int b = 0; b < loop2; b++) {
                    int temp = a;
                    if (temp == 6) {
                        temp = 9;
                    }
                    sb.append(temp);
                }
            }
            arr = sb.toString().toCharArray();
            Arrays.sort(arr);
            sb = new StringBuilder(new String(arr)).reverse();

            if (sb.length() % 2 == 1) {
                for (int a = 0; a < sb.length(); a += 2) {
                    result.append(sb.charAt(a)).append(" ");
                }
                for (int a = sb.length() - 2; a > 0; a -= 2) {
                    result.append(sb.charAt(a)).append(" ");
                }
            } else {
                for (int a = 0; a < sb.length(); a += 2) {
                    result.append(sb.charAt(a)).append(" ");
                }
                for (int a = sb.length() - 1; a >= 0; a -= 2) {
                    result.append(sb.charAt(a)).append(" ");
                }
            }
            result.append("\n");
        }
        System.out.println(result);
    }
}