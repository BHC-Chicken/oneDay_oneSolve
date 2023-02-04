import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String word = br.readLine();
        String answer = "";
        int mid = 0;
        int[] arr = new int[26];

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'A';
            arr[idx]++;
        }

        int one = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                one++;
                mid = i;
            }
        }

        if (one > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        } else {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < arr[i] / 2; j++) {
                    sb.append((char)(i + 'A'));
                }
            }

            answer += sb.toString();
            String reverse = sb.reverse().toString();

            if (one != 0) {
                answer += (char) (mid + 'A');
            }
            answer += reverse;
        }

        System.out.println(answer);

    }
}