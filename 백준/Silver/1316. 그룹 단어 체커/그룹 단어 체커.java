import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int sum = 0;

        for (int i = 0; i < num; i++) {
            String word = br.readLine();
            boolean[] flag = new boolean[27];
            boolean second = true;
            for (int a = 0; a < word.length() - 1; a++) {
                if (word.charAt(a) == word.charAt(a + 1)) {
                    continue;
                }
                int alpha = word.charAt(a) - 'a';
                if (flag[alpha]) {
                    second = false;
                    break;
                }
                flag[alpha] = true;
            }
            if (flag[word.charAt(word.length() - 1) - 'a']) {
                second = false;
            }
            if (word.length() == 1) {
                second = true;
            }
            if (second) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
