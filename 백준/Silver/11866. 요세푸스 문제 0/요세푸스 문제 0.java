import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int die = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= die; i++) {
            queue.add(i);
        }

        sb.append("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < num - 1; i++) {
                int temp = queue.poll();
                queue.add(temp);
            }
            sb.append(queue.poll());
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}