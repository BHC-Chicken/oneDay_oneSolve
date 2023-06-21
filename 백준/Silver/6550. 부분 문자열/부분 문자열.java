import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            String word = br.readLine();

            if (word == null || word.length() == 0) {
                break;
            }

            st = new StringTokenizer(word);
            
            String word1 = st.nextToken();
            String word2 = st.nextToken();

            int index = 0;

            for (int i = 0; i < word2.length(); i++) {
                if (word2.charAt(i) == word1.charAt(index)) {
                    index++;
                    if (index == word1.length()) {
                        break;
                    }
                }
            }

            if (index == word1.length()) {
                sb.append("Yes").append("\n");
            } else {
                sb.append("No").append("\n");
            }
        }

        System.out.println(sb);
    }
}
