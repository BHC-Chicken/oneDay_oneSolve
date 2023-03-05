import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int length = Integer.parseInt(br.readLine());
        int count = 0;

        StringBuilder find = new StringBuilder("IOI");
        String word = br.readLine();

        find.append("OI".repeat(Math.max(0, num - 1)));

        for (int i = 0; i < length; i++) {
            if (word.charAt(i) == 'I') {
                if (i + find.length() > word.length()) {
                    break;
                }
                String temp = word.substring(i, i + find.length());
                if (temp.equals(find.toString())) {
                    count++;
                    i++;
                }
            }
        }

        System.out.println(count);
    }
}
