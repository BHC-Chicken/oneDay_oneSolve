import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {

            int building = Integer.parseInt(br.readLine());

            List<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            while (st.hasMoreTokens()) {
                Integer token = Integer.parseInt(st.nextToken());
                list.add(token);
            }

            for (int j = 2; j < building - 2; j++) {

                /* 건물 없을때 pass */
                if (list.get(j) == 0) {
                    continue;
                }

                /* 만약 왼쪽에 건물 2개 이상이면. 왼쪽, 오른쪽 높이 판별 */

                if ((list.get(j) >= list.get(j - 1)) && list.get(j) >= list.get(j - 2)
                        && (list.get(j) >= list.get(j + 1)) && list.get(j) >= list.get(j + 2)
                ) {
                    int max = Math.max(Math.max(list.get(j + 1), list.get(j + 2)),
                            Math.max(list.get(j - 1), list.get(j - 2)));

                    count += list.get(j) - max;
                }
            }
            sb.append("#").append(i + 1).append(" ").append(count).append("\n");
            count = 0;
        }

        System.out.println(sb);


    }
}
