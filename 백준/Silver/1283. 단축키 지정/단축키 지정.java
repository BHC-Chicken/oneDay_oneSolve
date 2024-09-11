import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int index = 0;
            boolean flag = false;
            String word = br.readLine();
            String[] words = word.split(" ");

            for (int j = 0; j < words.length; j++) {
                String upperCase = words[j].toUpperCase();

                int charIndex = upperCase.charAt(0) - 'A';

                if (alphabet[charIndex] != 1) {
                    alphabet[charIndex] = 1;

                    index = j;
                    flag = true;

                    break;
                }
            }

            if (flag) {
                for (int j = 0; j < words.length; j++) {
                    if (j == index) {
                        sb.append("[").append(words[j].charAt(0)).append("]").append(words[j].substring(1)).append(" ");
                    } else {
                        sb.append(words[j]).append(" ");
                    }
                }

                sb.append("\n");

                continue;
            }

            for (int j = 0; j < word.length(); j++) {
                String upperCase = word.toUpperCase();

                int charIndex = upperCase.charAt(j) - 'A';

                if (charIndex < 0 || charIndex > 26) {
                    continue;
                }

                if (alphabet[charIndex] != 1) {
                    alphabet[charIndex] = 1;

                    index = j;
                    flag = true;

                    break;
                }
            }

            if (flag) {
                for (int j = 0; j < word.length(); j++) {
                    if (j == index) {
                        sb.append("[").append(word.charAt(index)).append("]");
                    } else {
                        sb.append(word.charAt(j));
                    }
                }

                sb.append("\n");

                continue;
            }

            sb.append(word).append("\n");

        }

        System.out.println(sb);
    }
}
