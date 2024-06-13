import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 0;
        LinkedList<String> daegun = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            daegun.add(br.readLine());
        }

        int index = 0;

        for (int i = 0; i < n; i++) {
            String carNumber = br.readLine();

            if (!daegun.get(index).equals(carNumber)) {
                result++;
                daegun.remove(carNumber);
            } else {
                index++;
            }
        }

        System.out.println(result);
    }
}