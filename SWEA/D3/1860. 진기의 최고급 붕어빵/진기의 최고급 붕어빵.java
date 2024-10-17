import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= tc; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int prev = 0;
            int bread = 0;
            boolean flag = true;

            st = new StringTokenizer(br.readLine());

            ArrayList<Integer> list = new ArrayList<>();

            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);

            sb.append("#").append(testCase).append(" ");

            for (int i = 0; i < n; i++) {
                int time = list.get(i);
                int timeGap = time - ((prev / m) * m);

                if (timeGap >= m) {
                    bread += (k * (timeGap / m));
                    bread -= 1;
                    prev = time;
                } else {
                    if (bread <= 0) {
                        sb.append("Impossible");
                        flag = false;

                        break;
                    } else {
                        bread -= 1;
                    }
                }
            }

            if (flag) {
                sb.append("Possible");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
