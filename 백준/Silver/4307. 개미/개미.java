import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < test_case; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int ant = Integer.parseInt(st.nextToken());
            int max = -1;
            int min = -1;

            for (int j = 0; j < ant; j++) {
                int num = Integer.parseInt(br.readLine());

                if ((length / 2) > num) {
                    max = Math.max(max, num);
                    min = Math.max(min, length - num);
                } else {
                    max = Math.max(max, length - num);
                    min = Math.max(min, num);
                }
            }
            sb.append(max).append(" ").append(min).append("\n");
        }

        System.out.println(sb);
    }
}