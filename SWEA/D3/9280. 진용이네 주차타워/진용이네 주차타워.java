import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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

            int[] parking = new int[n + 1];
            int[] isParking = new int[n + 1];
            int[] weight = new int[m + 1];

            int full = 0;
            int money = 0;
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                parking[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 1; i <= m; i++) {
                weight[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < 2 * m; i++) {
                int car = Integer.parseInt(br.readLine());

                if (car < 0) {
                    int temp = car * -1;
                    for (int j = 1; j <= n; j++) {
                        if (isParking[j] == temp) {
                            isParking[j] = 0;
                            full--;

                            break;
                        }
                    }

                    if (!queue.isEmpty()) {

                        car = queue.poll();
                    }
                }


                if (full == n) {
                    queue.add(car);

                    continue;
                }

                if (car > 0) {
                    for (int j = 1; j <= n; j++) {
                        if (isParking[j] == 0) {
                            full++;

                            isParking[j] = car;
                            money += weight[car] * parking[j];

                            break;
                        }
                    }
                }
            }

            sb.append("#").append(testCase).append(" ").append(money).append("\n");
        }

        System.out.println(sb);
    }
}
