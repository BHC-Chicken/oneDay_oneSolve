import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> set = new HashSet<>();
        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < word.length(); j++) {
                sb.append(word.substring(j, j + 1));
                set.add(sb.toString());
            }
        }

        System.out.println(set.size());
    }
}