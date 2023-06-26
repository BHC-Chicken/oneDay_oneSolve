import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        String word2 = br.readLine();

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for (int i = 0; i < word2.length(); i++) {
            str1.append(word1);
        }

        for (int i = 0; i < word1.length(); i++) {
            str2.append(word2);
        }

        if (str1.toString().equals(str2.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
