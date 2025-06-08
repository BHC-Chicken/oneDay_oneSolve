import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word1 = br.readLine();
        String word2 = br.readLine();
        int result = word1.length() + word2.length();

        String gear1;
        String gear2;
        if (word1.length() >= word2.length()) {
            gear1 = word1;
            gear2 = word2;
        } else {
            gear1 = word2;
            gear2 = word1;
        }

        int index = 1;
        for (int i = gear2.length() - 1; i > 0; i--) {
            boolean flag = true;
            int end = Math.min(gear2.length(), index++);

            for (int j = 0; j < end; j++) {
                if (gear1.charAt(j) == '2' && gear2.charAt(i + j) == '2') {
                    flag = false;

                    break;
                }
            }

            if (flag) {
                result = Math.min(result, gear2.length() - end + gear1.length());
            }
        }


        for (int i = 0; i < gear1.length(); i++) {
            boolean flag = true;
            int end = Math.min(gear2.length(), gear1.length() - i);
            for (int j = 0; j < end; j++) {
                if (gear1.charAt(i + j) == '2' && gear2.charAt(j) == '2') {
                    flag = false;

                    break;
                }
            }

            if (flag) {
                int length = 0;

                if (end >= gear2.length()) {
                    length = gear1.length();
                } else {
                    length = i + gear2.length();
                }

                result = Math.min(result, length);
            }
        }

        System.out.println(result);
    }
}
