import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];

        int start = Integer.MAX_VALUE;
        int end = -1;

        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");

            int l = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);

            arr[l] = h;

            start = Math.min(start, l);
            end = Math.max(end, l);
        }

        Deque<Integer> deque = new ArrayDeque<>();

        int leftStart = arr[start];

        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < leftStart) {
                deque.push(i);
            } else {
                while (!deque.isEmpty()) {
                    int temp = deque.pop();
                    arr[temp] = leftStart;
                }

                leftStart = arr[i];
            }
        }

        deque = new ArrayDeque<>();
        int rightStart = arr[end];

        for (int i = end - 1; i >= start ; i--) {
            if (arr[i] < rightStart) {
                deque.push(i);
            } else {
                while (!deque.isEmpty()) {
                    int temp = deque.pop();
                    arr[temp] = rightStart;
                }

                rightStart = arr[i];
            }
        }

        int result = 0;

        for (int i = start; i <= end; i++) {
            result += arr[i];
        }

        System.out.println(result);
    }
}
