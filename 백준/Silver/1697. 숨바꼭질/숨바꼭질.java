import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        HideAndSeekSolution HASS = new HideAndSeekSolution();
        HASS.init();
        HASS.solve();
    }
}

class HideAndSeekSolution {

    static int start, end;

    static int[] path;
    static boolean[] visited;

    public void solve() {

        int res = bfs();
        System.out.print(res);
    }

    public int bfs() {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int cur = queue.poll();
            if (cur == end) {
                return path[end];
            }

            int up = cur + 1;
            if (up < 100001 && !visited[up]) {
                queue.add(up);
                visited[up] = true;
                path[up] = path[cur] + 1;
            }

            int down = cur - 1;
            if (down >= 0 && !visited[down]) {
                queue.add(down);
                visited[down] = true;
                path[down] = path[cur] + 1;
            }

            int teleport = cur * 2;
            if (teleport < 100001 && !visited[teleport]) {
                queue.add(teleport);
                visited[teleport] = true;
                path[teleport] = path[cur] + 1;
            }
        }

        return -1;
    }

    public void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        path = new int[100001];
        visited = new boolean[100001];
    }
}