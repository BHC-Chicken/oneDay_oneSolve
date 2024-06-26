import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            String[] cmd = br.readLine().split("");
            int numLength = Integer.parseInt(br.readLine());

            String[] nums = br.readLine().replace("[", "").replace("]", "").split(",");

            Deque<Integer> deque = new ArrayDeque<>();

            for (String num : nums) {
                if (!num.isEmpty()) {
                    deque.add(Integer.parseInt(num));
                }
            }

            boolean check = false;
            boolean errorCheck = false;

            for (String s : cmd) {
                if (s.equals("R")) {
                    check = !check;
                } else if (s.equals("D")) {
                    if (deque.isEmpty()) {
                        result.append("error").append("\n");
                        errorCheck = true;

                        break;
                    }

                    if (check) {
                        deque.pollLast();
                    } else {
                        deque.poll();
                    }
                }
            }

            if (!errorCheck) {
                result.append("[");
                int size = deque.size();

                if (check) {
                    for (int j = 0; j < size; j++) {
                        result.append(deque.pollLast());

                        if (j < size - 1) {
                            result.append(",");
                        }
                    }
                } else {
                    for (int j = 0; j < size; j++) {
                        result.append(deque.poll());

                        if (j < size - 1) {
                            result.append(",");
                        }
                    }
                }

                result.append("]").append("\n");
            }

        }

        System.out.println(result);
    }
}