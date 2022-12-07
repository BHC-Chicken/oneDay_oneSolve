import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int loop = Integer.parseInt(br.readLine());
            if (loop == 0) {
                break;
            }
            ArrayList<String> word = new ArrayList<>();
            for (int i = 0; i < loop; i++) {
                word.add(br.readLine());
            }
            word.sort(String.CASE_INSENSITIVE_ORDER);
            System.out.println(word.get(0));

        }
    }
}