import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < tc; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int distance = end - start;
            int max = (int) Math.sqrt(distance);

            if (max == Math.sqrt(distance)) {
                sb.append(max * 2 - 1).append("\n");
            } else if (distance <= max * max + max) {
                sb.append(max * 2).append("\n");
            } else {
                sb.append(max * 2 + 1).append("\n");
            }
        }

        System.out.println(sb);
    }
}