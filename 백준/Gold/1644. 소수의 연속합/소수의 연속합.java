import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        int count = 0;

        boolean[] arr = new boolean[loop + 1];
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;

        for (int i = 2; i * i <= loop; i++) {
            for (int j = i * i; j <= loop; j += i) {
                arr[j] = false;
            }
        }
        for (int i = 0; i <= loop; i++) {
            if (arr[i]) {
                list.add(i);
            }
        }

        int point = 0;
        for (int i = 0; i < loop; i++) {
            int sum = 0;
            for (int j = point; j < list.size(); j++) {
                sum += list.get(j);
                if (sum == loop) {
                    count++;
                } else if (sum > loop) {
                    break;
                }
            }
            point++;
        }

        System.out.println(count);
    }
}