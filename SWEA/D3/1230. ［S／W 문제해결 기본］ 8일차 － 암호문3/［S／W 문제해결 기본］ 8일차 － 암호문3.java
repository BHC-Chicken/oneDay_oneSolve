import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int num = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < num; i++) {
                String cmd = st.nextToken();

                if (cmd.equals("I")) {
                    int start = Integer.parseInt(st.nextToken());
                    int end = Integer.parseInt(st.nextToken());

                    for (int j = 0; j < end; j++) {
                        list.add(start, Integer.parseInt(st.nextToken()));

                        start += 1;
                    }
                } else if (cmd.equals("D")) {
                    int start = Integer.parseInt(st.nextToken());
                    int end = Integer.parseInt(st.nextToken());

                    for (int j = 0; j < end; j++) {
                        list.remove(start);
                    }
                } else if (cmd.equals("A")) {
                    int loop = Integer.parseInt(st.nextToken());

                    for (int j = 0; j < loop; j++) {
                        list.add(Integer.parseInt(st.nextToken()));
                    }
                }
            }
            sb.append("#").append(tc).append(" ");

            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
