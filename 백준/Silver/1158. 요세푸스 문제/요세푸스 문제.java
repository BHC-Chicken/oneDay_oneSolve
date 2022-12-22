import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        sb.append("<");
        while (queue.size() != 0) {
            for (int i = 0; i < k - 1; i++) {
                int temp = queue.remove();
                queue.add(temp);
            }
            sb.append(queue.remove());
            if (queue.size() != 0) {
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}