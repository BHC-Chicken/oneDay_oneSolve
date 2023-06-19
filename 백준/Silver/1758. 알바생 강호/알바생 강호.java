import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        long sum = 0;

        for (int i = 0; i < loop; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Collections.reverseOrder());

        for (int i = 1; i <= loop; i++) {
            int num = list.get(i - 1) - (i - 1);
            if (num > 0) {
                sum += num;
            }
        }

        System.out.println(sum);
    }
}
