import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String word1 = st.nextToken();
        String word2 = st.nextToken();

        int result = word1.length();
        int count;

        if (word2.contains(word1)) {
            System.out.println(0);

            return;
        } else {
            for (int i = 0; i < word2.length() - word1.length() + 1; i++) {
                count = 0;
                for (int j = 0; j < word1.length(); j++) {
                    if (word2.charAt(i + j) != word1.charAt(j)) {
                        count++;
                    }
                }
                if (result > count) {
                    result = count;
                }
            }
        }

        System.out.println(result);
    }
}
