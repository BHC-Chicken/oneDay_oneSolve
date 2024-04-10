import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] arr = pattern.split("\\*");

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            if (arr[0].length() + arr[1].length() > word.length()) {
                sb.append("NE").append("\n");

                continue;
            }

            String startPattern = word.substring(0, arr[0].length());
            String endPattern = word.substring(word.length() - arr[1].length());

            if (arr[0].equals(startPattern) && arr[1].equals(endPattern)) {
                sb.append("DA").append("\n");
            } else {
                sb.append("NE").append("\n");
            }
        }

        System.out.println(sb);
    }
}
