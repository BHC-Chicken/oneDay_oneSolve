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
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            arr[b]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();
            sb.append(num).append(" ");

            for (int i : list.get(num)) {
                arr[i]--;
                if (arr[i] == 0) {
                    queue.add(i);
                }
            }
        }

        System.out.println(sb);
    }
}
