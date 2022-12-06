import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int loop = Integer.parseInt(br.readLine());
        String word = br.readLine();
        sb.append(word);
        int[] replace = new int[word.length() + 1];

        for (int i = 0; i < loop - 1; i++) {
            String word2 = br.readLine();
            for (int a = 0; a < word.length(); a++) {
                if (word.charAt(a) != word2.charAt(a)) {
                    replace[a]++;
                }
            }
        }

        for (int i = 0; i < word.length(); i++) {
            if (replace[i] >= 1) {
                sb.setCharAt(i,'?');
            }
        }

        System.out.println(sb);
    }
}