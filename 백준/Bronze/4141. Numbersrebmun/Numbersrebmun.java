import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < test_case; i++) {
            String word = br.readLine().toUpperCase();
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < word.length(); j++) {
                int num = word.charAt(j) - 'A';
                sb.append(arr[num]);
            }
            String word2 = sb.toString();
            if (word2.contentEquals(sb.reverse())) {
                result.append("YES").append("\n");
            } else {
                result.append("NO").append("\n");
            }
        }

        System.out.println(result);
    }
}
