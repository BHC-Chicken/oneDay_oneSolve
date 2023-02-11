import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int value = Integer.parseInt(br.readLine());
        int max = 0;
        int count = 0;
        boolean flag = true;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < value; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        while (flag) {
            int sum = 0;
            int num = list.get(count);
            for (int i = count; i < value; i++) {
                sum += num;
            }
            if (max < sum) {
                max = sum;
            }
            count++;
            if (count == list.size()) {
                flag=false;
            }
        }

        System.out.println(max);
    }
}