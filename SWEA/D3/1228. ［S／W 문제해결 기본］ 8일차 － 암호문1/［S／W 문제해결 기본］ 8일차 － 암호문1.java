import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            int num = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            num = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "I");

            for (int j = 0; j < num; j++) {
                String[] cmd = st.nextToken().split(" ");

                int start = Integer.parseInt(cmd[1]);
                int end = Integer.parseInt(cmd[2]);

                for (int k = 0; k < end; k++) {
                    list.add(start, Integer.parseInt(cmd[3 + k]));
                    start += 1;
                }
            }

            sb.append("#").append(i).append(" ");

            for (int j = 0; j < 10; j++) {
                sb.append(list.get(j)).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
