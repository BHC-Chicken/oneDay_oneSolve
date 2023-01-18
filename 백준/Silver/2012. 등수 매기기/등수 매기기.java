import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int loop = Integer.parseInt(br.readLine());
        long sum = 0;

        for (int i = 0; i < loop; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for (int i = 0; i < loop; i++) {
            sum += Math.abs(list.get(i) - (i + 1));
        }

        System.out.println(sum);
    }
}