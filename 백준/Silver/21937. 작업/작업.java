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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(end).add(start);
        }

        int x = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>(list.get(x));
        int count = 0;
        boolean[] visited = new boolean[n + 1];
        visited[x] = true;

        while (!queue.isEmpty()) {
            int job = queue.poll();
            boolean[] tempVisited = new boolean[n + 1];

            if (!visited[job]) {
                visited[job] = true;

                ArrayList<Integer> temp = list.get(job);

                for (Integer integer : temp) {
                    if (!tempVisited[integer]) {
                        queue.add(integer);
                        tempVisited[integer] = true;
                    }
                }

                count++;
            }
        }

        System.out.println(count);
    }
}
