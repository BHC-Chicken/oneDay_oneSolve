import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        String find = br.readLine();
        int result = 0;
        
        if (word.length() < find.length()) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            if (word.substring(i, i + find.length()).equals(find)) {
                result++;
                i += find.length() - 1;
            }
            if (i + find.length() >= word.length()) {
                break;
            }
        }

        System.out.println(result);
    }
}