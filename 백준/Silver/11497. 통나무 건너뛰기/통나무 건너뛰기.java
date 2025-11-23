import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);

            int answer = list.get(1) - list.get(0);

            for (int j = 0; j < n - 2; j++) {
                int gap = list.get(j + 2) - list.get(j);
                answer = Math.max(answer, gap);
            }

            sb.append(answer).append("\n");

        }

        System.out.println(sb);
    }
}
