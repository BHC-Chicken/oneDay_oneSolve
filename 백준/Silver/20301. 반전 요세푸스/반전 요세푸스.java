import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        while (!deque.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                int temp = deque.poll();
                deque.add(temp);
            }

            sb.append(deque.poll()).append("\n");

            count++;
            if (count == m) {
                while (count-- > 0) {
                    if (deque.isEmpty()) {
                        break;
                    }
                    for (int i = 0; i < k - 1; i++) {
                        int temp = deque.pollLast();
                        deque.addFirst(temp);
                    }
                    sb.append(deque.pollLast()).append("\n");
                }
                count = 0;
            }
        }

        System.out.println(sb);
    }
}
