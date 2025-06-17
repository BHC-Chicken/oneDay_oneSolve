import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Queue<String>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayDeque<>());
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<String> queue = list.get(i);
            while (st.hasMoreTokens()) {
                queue.add(st.nextToken());
            }
        }

        String[] complete = br.readLine().split(" ");

        boolean flag = true;

        for (String s : complete) {
            for (int j = 0; j < n; j++) {
                Queue<String> queue = list.get(j);
                if (!queue.isEmpty() && queue.peek().equals(s)) {
                    queue.poll();
                    flag = true;

                    break;
                } else {
                    flag = false;
                }
            }

            if (!flag) {
                System.out.println("Impossible");

                return;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!list.get(i).isEmpty()) {
                System.out.println("Impossible");
                
                return;
            }
        }

        System.out.println("Possible");
    }
}
