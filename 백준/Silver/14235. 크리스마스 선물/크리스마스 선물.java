import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(priorityQueue.poll()).append("\n");
                }
            } else {
                while (st.hasMoreTokens()) {
                    priorityQueue.add(Integer.parseInt(st.nextToken()));
                }
            }
        }

        System.out.println(sb);
    }
}
