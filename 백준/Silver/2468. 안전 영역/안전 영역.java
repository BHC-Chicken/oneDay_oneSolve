import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    static int result = Integer.MIN_VALUE;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                max = Math.max(max, num);
            }
        }

        for (int height = 0; height < max; height++) {
            visited = new boolean[n][n];
            Queue<Pair> pairs = new LinkedList<>();
            int count = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] > height && !visited[j][k]) {
                        count++;
                        pairs.add(new Pair(j, k));

                        while (!pairs.isEmpty()) {
                            Pair pair = pairs.poll();
                            int x = pair.x;
                            int y = pair.y;

                            visited[x][y] = true;

                            for (int l = 0; l < 4; l++) {
                                int nx = x + dx[l];
                                int ny = y + dy[l];

                                if (inRange(nx, ny) && map[nx][ny] > height && !visited[nx][ny]) {
                                    pairs.add(new Pair(nx, ny));
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                }
            }

            result = Math.max(result, count);
        }

        System.out.println(result);
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