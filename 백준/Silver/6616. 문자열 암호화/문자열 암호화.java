import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            String word = br.readLine().toUpperCase().replaceAll(" ", "");
            StringBuilder sb = new StringBuilder();
            char[] arr = new char[word.length()];
            int index = 0;
            int index2 = 0;

            while (index2 < word.length()) {
                for (int j = index; j < word.length(); j += num) {
                    arr[j] = word.charAt(index2);
                    index2++;
                }
                index++;
            }

            for (char c : arr) {
                sb.append(c);
            }

            System.out.println(sb);
        }
    }
}