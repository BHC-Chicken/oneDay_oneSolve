import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int loop = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < loop; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean check = false;
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            for (int i = x; i < (n * m); i+= m) {
                if (i % n == y) {
                    sb.append(i + 1).append("\n");
                    check = true;

                    break;
                }
            }

            if (!check) {
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
