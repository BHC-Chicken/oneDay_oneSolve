import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            if (i == word.length() - 1) {
                break;
            }

            if (temp != word.charAt(i + 1)) {
                while (temp != word.charAt(i + 1)) {
                    i++;
                    if (i == word.length() - 1) {
                        break;
                    }
                }
                count++;
            }
        }

        System.out.println(count);
    }

}