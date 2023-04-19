import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.FileInputStream;

class Solution
{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int test_case = Integer.parseInt(br.readLine());

        for (int i = 1; i <= test_case; i++) {
            st = new StringTokenizer(br.readLine());
            float sum = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>();

            for (int j = 0; j < 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
            }

            queue.poll();

            for (int j = 0; j < 8; j++) {
                int temp = queue.poll();
                sum += temp;
            }

            int result = Math.round(sum/8);

            sb.append("#").append(i).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }
}