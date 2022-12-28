import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int loop = Integer.parseInt(br.readLine());

        for (int i = 1; i <= loop; i++) {
            ArrayList<String> list = new ArrayList<>();
            String[] word = br.readLine().split(" ");
            sb.append("Case #").append(i).append(": ");
            for (int a = word.length - 1; a >= 0; a--) {
                sb.append(word[a]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}