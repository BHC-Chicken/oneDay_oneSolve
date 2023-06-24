import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            String word = br.readLine();
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[26];

            if (num == 1) {
                sb.append(1).append(" ").append(1).append("\n");
                continue;
            }

            for (int j = 0; j < word.length(); j++) {
                arr[word.charAt(j) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = -1;

            for (int j = 0; j < word.length(); j++) {
                if (arr[word.charAt(j) - 'a'] < num) {
                    continue;
                }

                int count = 1;
                for (int k = j + 1; k < word.length(); k++) {
                    if (word.charAt(j) == word.charAt(k)) {
                        count++;
                    }
                    if (count == num) {
                        min = Math.min(min, k - j + 1);
                        max = Math.max(max, k - j + 1);
                        break;
                    }
                }
            }
            if (min == Integer.MAX_VALUE || max == -1) {
                sb.append(-1).append("\n");
            } else {
                sb.append(min).append(" ").append(max).append("\n");
            }
        }

        System.out.println(sb);
    }
}
