import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 65 && word.charAt(i) <= 90) {
                sb.append(String.valueOf(word.charAt(i)).toLowerCase());
            } else {
                sb.append(String.valueOf(word.charAt(i)).toUpperCase());
            }
        }

        System.out.println(sb);
    }
}