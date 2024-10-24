import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int h;
    static int[][][] map;

    static boolean inRange(int x, int y, int z) {
        return x >= 0 && x < n && y >= 0 && y < m && z >= 0 && z < h;
    }

    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int result = 0;
        int zeroCount = 0;

        map = new int[n][m][h];
        Queue<Tuple> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[j][k][i] = num;

                    if (num == 1) {
                        queue.add(new Tuple(j, k, i));
                    }
                    if (num == 0) {
                        zeroCount++;
                    }
                }
            }
        }

        if (zeroCount == 0) {
            System.out.println(0);

            return;
        }

        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();

            for (int z = 0; z < size; z++) {
                Tuple start = queue.poll();

                for (int i = 0; i < 6; i++) {
                    int nx = start.x + dx[i];
                    int ny = start.y + dy[i];
                    int nz = start.z + dh[i];

                    if (inRange(nx, ny, nz) && map[nx][ny][nz] == 0) {
                        queue.add(new Tuple(nx, ny, nz));
                        map[nx][ny][nz] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[j][k][i] == 0) {
                        System.out.println(-1);

                        return;
                    }
                }
            }
        }

        System.out.println(result - 1);
    }
}

class Tuple {
    int x;
    int y;
    int z;

    public Tuple(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
