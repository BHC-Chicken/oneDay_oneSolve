import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int size;
    static int startX;
    static int startY;
    static int endX;
    static int endY;

    static Queue<Pair> queue;
    static int[][] result;
    static boolean[][] visited;

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < tc; i++) {
            queue = new LinkedList<>();
            size = Integer.parseInt(br.readLine());
            result = new int[size][size];
            visited = new boolean[size][size];

            st = new StringTokenizer(br.readLine());

            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            queue.add(new Pair(startX, startY));
            visited[startX][startY] = true;
            result[startX][startY] = 0;

            bfs();

            sb.append(result[endX][endY]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Pair start = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = start.x + dx[i];
                int ny = start.y + dy[i];

                if (inRange(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Pair(nx, ny));
                    result[nx][ny] = result[start.x][start.y] + 1;
                }
            }
        }
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}