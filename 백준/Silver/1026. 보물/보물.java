import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        int sum = 0;

        ArrayList<Integer> num1 = new ArrayList<>();
        ArrayList<Integer> num2 = new ArrayList<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        while (st1.hasMoreTokens()) {
            num1.add(Integer.parseInt(st1.nextToken()));
            num2.add(Integer.parseInt(st2.nextToken()));
        }

        Collections.sort(num1);
        num2.sort(Collections.reverseOrder());

        for (int i = 0; i < loop; i++) {
            sum += num1.get(i) * num2.get(i);
        }

        System.out.println(sum);
    }
}