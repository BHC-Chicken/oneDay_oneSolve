import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
        }

        int result = 0;

        for (int i = 0; i < num; i++) {
            result = queue.poll();
        }

        System.out.println(result);
    }
}