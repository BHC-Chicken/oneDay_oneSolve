import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int road = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(road);

        if (n > 0) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        Collections.sort(list);

        int left = 1;
        int right = road;
        int result = road;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;

            for (int i = 1; i < list.size(); i++) {
                int gap = list.get(i) - list.get(i - 1);

                if (gap > mid) {
                    count += (gap - 1) / mid;
                }
            }

            if (count <= m) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
