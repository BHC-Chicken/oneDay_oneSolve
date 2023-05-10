import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int sum = list.get(left) + list.get(right);

            if (sum == m) {
                answer++;
                right--;
                left++;
            } else if (sum > m) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(answer);
    }
}
