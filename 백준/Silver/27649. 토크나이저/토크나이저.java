import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();
        StringBuilder sb = new StringBuilder();

        words = words.replace("&&", " && ");
        words = words.replace("||", " || ");
        words = words.replace("(", " ( ");
        words = words.replace(")", " ) ");
        words = words.replace("<", " < ");
        words = words.replace(">", " > ");

        String[] tokens = words.trim().split("\\s+");

        for (String token : tokens) {
            sb.append(token).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
