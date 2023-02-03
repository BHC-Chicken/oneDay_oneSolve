import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        int count = 0;

        int queueSize = Integer.parseInt(st.nextToken());
        int test_case = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= queueSize; i++) {
            queue.add(i);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < test_case; i++) {
            int target = Integer.parseInt(st.nextToken());
            int idx = queue.indexOf(target);
            int size;

            if (queue.size() % 2 == 0) {
                size = queue.size() / 2 - 1;
            } else {
                size = queue.size() / 2;
            }

            if (idx <= size) {
                while (queue.peek() != target) {
                    int temp = queue.pollFirst();
                    queue.addLast(temp);
                    count++;
                }
            } else {
                while (queue.peek() != target) {
                    int temp = queue.pollLast();
                    queue.addFirst(temp);
                    count++;
                }
            }
            queue.poll();
        }
        System.out.println(count);
    }
}