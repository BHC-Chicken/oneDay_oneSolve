import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static int[][] map;
    static int upCleaner;
    static int downCleaner;
    static Queue<Pair> queue = new ArrayDeque<>();

    static void spread(Queue<Pair> spreadQueue) {
        while (!spreadQueue.isEmpty()) {
            Pair pair = spreadQueue.poll();

            map[pair.x][pair.y] += pair.value;
        }
    }

    static void reverseTimeDirClean() {
        int nx = upCleaner;
        int prev = map[nx][1];
        map[nx][1] = 0;

        for (int i = 2; i < c; i++) {
            int temp = map[nx][i];
            map[nx][i] = prev;
            prev = temp;
        }

        for (int i = nx - 1; i >= 0; i--) {
            int temp = map[i][c - 1];
            map[i][c - 1] = prev;
            prev = temp;
        }

        for (int i = c - 2; i >= 0; i--) {
            int temp = map[0][i];
            map[0][i] = prev;
            prev = temp;
        }

        for (int i = 1; i < nx; i++) {
            int temp = map[i][0];
            map[i][0] = prev;
            prev = temp;
        }
    }

    static void timeDirClean() {
        int nx = downCleaner;
        int prev = map[nx][1];
        map[nx][1] = 0;

        for (int i = 2; i < c; i++) {
            int temp = map[nx][i];
            map[nx][i] = prev;
            prev = temp;
        }

        for (int i = nx + 1; i < r; i++) {
            int temp = map[i][c - 1];
            map[i][c - 1] = prev;
            prev = temp;
        }

        for (int i = c - 2; i >= 0; i--) {
            int temp = map[r - 1][i];
            map[r - 1][i] = prev;
            prev = temp;
        }

        for (int i = r - 2; i > nx; i--) {
            int temp = map[i][0];
            map[i][0] = prev;
            prev = temp;
        }
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        upCleaner = 0;
        downCleaner = 0;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == -1) {
                    downCleaner = i;
                }

                if (map[i][j] > 0 && map[i][j] != -1) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        upCleaner = downCleaner - 1;

        while (t-- > 0) {
            queue.clear();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] > 0 && map[i][j] != -1) {
                        queue.add(new Pair(i, j, map[i][j]));
                    }
                }
            }

            int size = queue.size();
            Queue<Pair> spreadQueue = new ArrayDeque<>();

            for (int i = 0; i < size; i++) {
                int count = 0;
                Pair pair = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = pair.x + dx[j];
                    int ny = pair.y + dy[j];

                    if (inRange(nx, ny) && map[nx][ny] != -1 && map[pair.x][pair.y] / 5 >= 1) {
                        count++;
                        spreadQueue.add(new Pair(nx, ny, map[pair.x][pair.y] / 5));
                    }
                }

                if (count > 0) {
                    int dust = map[pair.x][pair.y];
                    int spreadAmount = map[pair.x][pair.y] / 5;
                    int val = dust - (spreadAmount * count);
                    map[pair.x][pair.y] = val;
                }
            }

            spread(spreadQueue);
            timeDirClean();
            reverseTimeDirClean();
        }

        int result = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result += map[i][j];
            }
        }

        System.out.println(result + 2);
    }
}

class Pair {
    int x;
    int y;
    int value;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
