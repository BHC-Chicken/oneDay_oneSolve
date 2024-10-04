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

        int[] dir = new int[2];

        int totalFloor = Integer.parseInt(st.nextToken());
        int now = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        dir[0] = Integer.parseInt(st.nextToken());
        dir[1] = - Integer.parseInt(st.nextToken());

        if (goal < now && dir[1] == 0) {
            System.out.println("use the stairs");

            return;
        }

        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[totalFloor + 1];

        queue.add(new Pair(now, 0));
        visited[now] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            if (pair.floor == goal) {
                System.out.println(pair.count);

                return;
            }

            for (int i = 0; i < 2; i++) {
                int next = pair.floor + dir[i];

                if (next > totalFloor || next < 1) {
                    continue;
                }

                if (!visited[next]) {
                    queue.add(new Pair(next, pair.count + 1));
                    visited[next] = true;
                }
            }
        }

        System.out.println("use the stairs");
    }
}

class Pair {
    int floor;
    int count;

    public Pair(int floor, int count) {
        this.floor = floor;
        this.count = count;
    }
}