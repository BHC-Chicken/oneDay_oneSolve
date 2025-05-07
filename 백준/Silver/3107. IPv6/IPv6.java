import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String IPv6 = br.readLine();

        StringTokenizer st = new StringTokenizer(IPv6, ":", true);
        StringBuilder sb = new StringBuilder();


        while (st.hasMoreTokens()) {
            String word = st.nextToken();

            if (word.equals(":")) {
                sb.append(word);

            } else {
                sb.append(String.format("%4s", word).replace(' ', '0'));
            }
        }

        StringBuilder result = new StringBuilder();

        if (sb.length() != 39) {
            String[] numbers = sb.toString().split("::");

            if (numbers.length == 0) {
                for (int i = 0; i < 8; i++) {
                    result.append("0000");
                    if (i != 7) {
                        result.append(":");
                    }
                }
            } else if (numbers.length == 1) {
                result.append(numbers[0]).append(":");

                int startIndex = numbers[0].length() / 4;

                if (startIndex >= 6) {
                    startIndex--;
                }

                for (int i = startIndex; i < 8; i++) {
                    result.append("0000");
                    if (i != 7) {
                        result.append(":");
                    }
                }

            } else {
                int startIndex = numbers[0].length() / 4;
                int endIndex = 8 - (numbers[1].length() / 4);

                if (startIndex >= 6) {
                    startIndex--;
                }

                if (numbers[0].equals("")) {
                    result.append("0000").append(":");
                    startIndex = 1;
                } else {
                    result.append(numbers[0]).append(":");
                }

                for (int i = startIndex; i < endIndex; i++) {
                    result.append("0000").append(":");
                }

                result.append(numbers[1]);
            }

            System.out.println(result);
        } else {
            System.out.println(sb);
        }
    }
}
