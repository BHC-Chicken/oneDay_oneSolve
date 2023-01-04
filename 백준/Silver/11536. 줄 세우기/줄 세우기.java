import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> compare = new ArrayList<>();

        for (int i = 0; i < test_case; i++) {
            String word = br.readLine();
            name.add(word);
            compare.add(word);
        }

        Collections.sort(name);
        if (name.equals(compare)) {
            System.out.println("INCREASING");
            return;
        }

        name.sort(Collections.reverseOrder());
        int count = name.size() - 1;

        for (int i = 0; i < name.size(); i++) {
            if (!name.get(i).equals(compare.get(i))) {
                System.out.println("NEITHER");
                return;
            }
            count--;
        }

        System.out.println("DECREASING");
    }
}