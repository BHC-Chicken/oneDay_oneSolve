import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int city = Integer.parseInt(st.nextToken());
        int road = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= city; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < road; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
        }

        int[] distance = new int[city + 1];
        Arrays.fill(distance, -1);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        distance[start] = 0;

        ArrayList<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (distance[current] > goal) {
                break;
            }

            if (distance[current] == goal) {
                result.add(current);
            }

            for (int next : list.get(current)) {
                if (distance[next] != -1) {
                    continue;
                }

                distance[next] = distance[current] + 1;
                queue.add(next);
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);

            return;
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();

        for (int i : result) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}
