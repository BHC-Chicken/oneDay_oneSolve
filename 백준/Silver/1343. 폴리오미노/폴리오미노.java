import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), ".", true);
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            String word = st.nextToken();

            if (word.contains(".")) {
                sb.append(word);
            } else {
                if (word.length() % 2 == 1) {
                    System.out.println(-1);
                    return;
                }

                if (word.length() == 2) {
                    sb.append("BB");
                } else if (word.length() == 4) {
                    sb.append("AAAA");
                } else {
                    int size = word.length();

                    while (!(size == 0)) {
                        if (size >= 4) {
                            sb.append("AAAA");
                            size -= 4;
                        } else {
                            sb.append("BB");
                            size -= 2;
                        }
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
