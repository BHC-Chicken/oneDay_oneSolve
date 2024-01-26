import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[num];

        for (int i = 1; i <= num; i++) {
            deque.add(i);
        }

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(deque.poll());
        int start = arr[0];
        int temp = 0;

        for (int i = 1; i < num; i++) {

            if (start > 0) {
                for (int j = 0; j < start - 1; j++) {
                    deque.add(deque.poll());
                }

                temp = deque.poll();
                start = arr[temp - 1];
            } else {
                start = Math.abs(start);
                for (int j = 0; j < start - 1; j++) {
                    deque.addFirst(deque.pollLast());
                }

                temp = deque.pollLast();
                start = arr[temp - 1];
            }

            sb.append(" ").append(temp);
        }

        System.out.println(sb);
    }
}