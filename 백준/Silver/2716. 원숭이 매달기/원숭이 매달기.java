import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            char[] c = br.readLine().toCharArray();
            int count = 0;
            int maxCount = 0;

            for (char ch : c) {
                if (ch == '[') {
                    count++;
                } else {
                    count--;
                }

                maxCount = Math.max(maxCount, count);
            }

            int result = 1;
            for (int j = 0; j < maxCount; j++) {
                result *= 2;
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
