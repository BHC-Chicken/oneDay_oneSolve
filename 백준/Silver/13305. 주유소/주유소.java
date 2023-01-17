import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int city = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> load = new ArrayList<>();
        ArrayList<Integer> oil = new ArrayList<>();

        for (int i = 0; i < city - 1; i++) {
            load.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < city - 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < min) {
                min = num;
            }
            oil.add(num);
        }

        for (int i = 0; i < city; i++) {
            if (oil.get(i) != min) {
                sum += oil.get(i) * load.get(i);
            } else {
                for (int j = i; j < city - 1; j++) {
                    sum += oil.get(i) * load.get(j);
                }
                break;
            }
        }
        System.out.println(sum);
    }
}