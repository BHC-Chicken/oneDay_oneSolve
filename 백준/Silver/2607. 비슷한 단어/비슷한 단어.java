import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] words = new int[27];
    static int charCount;

    static boolean check(String input) {
        int[] inputWords = new int[27];

        for (int i = 0; i < input.length(); i++) {
            inputWords[input.charAt(i) - 'A']++;
        }

        if (input.length() == charCount) {
            int sameCount = 0;

            for (int i = 0; i < 27; i++) {
                if (words[i] > 0 && inputWords[i] > 0) {
                    if (words[i] == inputWords[i]) {
                        sameCount += words[i];
                    } else {
                        int big = Math.max(words[i], inputWords[i]);

                        sameCount += (big - Math.abs(words[i] - inputWords[i]));
                    }
                }
            }

            return charCount - 1 <= sameCount;
        } else {
            int count = 0;

            for (int i = 0; i < 27; i++) {
                if (words[i] != inputWords[i]) {
                    count += Math.abs(words[i] - inputWords[i]);
                }

                if (count >= 2) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()) - 1;
        int count = 0;
        String word = br.readLine();
        charCount = word.length();

        for (int i = 0; i < word.length(); i++) {
            words[word.charAt(i) - 'A']++;
        }

        for (int i = 0; i < n; i++) {
            if (check(br.readLine())) {
                count++;
            }
        }

        System.out.println(count);
    }
}

