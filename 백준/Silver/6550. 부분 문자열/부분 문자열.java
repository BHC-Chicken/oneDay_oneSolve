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
            String word1;
            String word2;

            try {
                st = new StringTokenizer(br.readLine());

                word1 = st.nextToken();
                word2 = st.nextToken();
            } catch (Exception e) {
                break;
            }
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
