import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int l;
    static int r;
    static int[][] map;

    static ArrayList<Pair> moveList;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static int moveCheck() {
        visited = new boolean[n][n];
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        int moveCheck = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;

                    moveList = new ArrayList<>();
                    moveList.add(new Pair(i, j));

                    Pair pair = new Pair(i, j);
                    queue.add(pair);

                    int size = 1;
                    int sum = map[i][j];

                    while (!queue.isEmpty()) {
                        Pair now = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = now.x + dx[k];
                            int ny = now.y + dy[k];

                            if (inRange(nx, ny) && !visited[nx][ny]) {
                                int gap = Math.abs(map[now.x][now.y] - map[nx][ny]);

                                if (gap >= l && gap <= r) {
                                    queue.add(new Pair(nx, ny));
                                    visited[nx][ny] = true;
                                    size++;
                                    sum += map[nx][ny];
                                    moveCheck++;
                                    moveList.add(new Pair(nx, ny));
                                }
                            }
                        }
                    }

                    if (moveCheck > 0) {
                        move(sum / size);
                    }
                }
            }
        }

        return moveCheck;
    }

    static void move(int avg) {
        for (Pair pair : moveList) {
            map[pair.x][pair.y] = avg;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        int result = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());

                map[i][j] = num;
            }
        }

        while (moveCheck() != 0) {
            result++;
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
