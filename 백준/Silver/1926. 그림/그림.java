import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        int artCount = 0;
        int maxSize = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;
                } else {
                    continue;
                }

                int tempSize = 1;

                while (!queue.isEmpty()) {
                    Pair pair = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = pair.x + dx[k];
                        int ny = pair.y + dy[k];

                        if (inRange(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]) {
                            queue.add(new Pair(nx,ny));
                            visited[nx][ny] = true;
                            tempSize++;
                        }
                    }
                }

                artCount++;
                maxSize = Math.max(maxSize, tempSize);
            }
        }

        if (artCount == 0) {
            sb.append(0).append("\n").append(0);
        } else {
            sb.append(artCount).append("\n").append(maxSize);
        }

        System.out.println(sb);
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