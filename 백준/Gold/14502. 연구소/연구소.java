import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int wall;
    static int result;
    static int[][] map;
    static int[][] virusMap;
    static boolean[][] visited;
    static ArrayList<Pair> virus = new ArrayList<>();

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static void bfs() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Pair> queue = new ArrayDeque<>(virus);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            visited[pair.x][pair.y] = true;
            virusMap[pair.x][pair.y] = 1;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + pair.x;
                int ny = dy[i] + pair.y;

                if (inRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    virusMap[nx][ny] = 1;
                    queue.add(new Pair(nx,ny));
                }
            }
        }
    }

    static void countSafeZone() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virusMap[i][j] == 0) {
                    count++;
                }
            }
        }

        result = Math.max((count - wall), result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());

                map[i][j] = num;

                if (num == 1) {
                    wall++;
                }

                if (num == 2) {
                    virus.add(new Pair(i, j));
                }
            }
        }

        wall += 3;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    continue;
                }
                map[i][j] = 1;

                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        if (map[k][l] != 0) {
                            continue;
                        }
                        map[k][l] = 1;

                        for (int o = 0; o < n; o++) {
                            for (int p = 0; p < m; p++) {
                                if (map[o][p] != 0) {
                                    continue;
                                }

                                map[o][p] = 1;

                                virusMap = new int[n][m];
                                visited = new boolean[n][m];
                                bfs();
                                countSafeZone();

                                map[o][p] = 0;
                            }
                        }

                        map[k][l] = 0;
                    }
                }

                map[i][j] = 0;
            }
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
