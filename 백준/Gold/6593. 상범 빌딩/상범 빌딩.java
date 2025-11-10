import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String[][][] arr;
    static Tuple start;

    static int l;
    static int r;
    static int c;

    static int[] dx = {0, 0, 1, 0, -1, 0};
    static int[] dy = {0, 0, 0, 1, 0, -1};
    static int[] dz = {1, -1, 0, 0, 0, 0};

    static boolean inRange(int x, int y, int z) {
        return x >= 0 && x < l && y >= 0 && y < r && z >= 0 && z < c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            int time = Integer.MAX_VALUE;

            if (l == 0 && r == 0 && c == 0) {
                break;
            }

            arr = new String[l][r][c];

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String[] split = br.readLine().split("");
                    for (int k = 0; k < c; k++) {
                        String value = split[k];

                        if (value.equals("S")) {
                            start = new Tuple(i, j, k, 1);
                        }

                        arr[i][j][k] = value;
                    }
                }
                br.readLine();
            }

            Queue<Tuple> queue = new ArrayDeque<>();
            queue.add(start);
            boolean[][][] visited = new boolean[l][r][c];
            visited[start.l][start.r][start.c] = true;

            while (!queue.isEmpty()) {
                Tuple tuple = queue.poll();

                for (int i = 0; i < 6; i++) {
                    int nl = tuple.l + dz[i];
                    int nr = tuple.r + dx[i];
                    int nc = tuple.c + dy[i];

                    if (inRange(nl, nr, nc) && !visited[nl][nr][nc] && (arr[nl][nr][nc].equals(".") || arr[nl][nr][nc].equals("E"))) {
                        queue.add(new Tuple(nl, nr, nc, tuple.time + 1));
                        visited[nl][nr][nc] = true;

                        if (arr[nl][nr][nc].equals("E")) {
                            time = Math.min(time, tuple.time);
                        }
                    }
                }
            }

            if (time != Integer.MAX_VALUE) {
                sb.append("Escaped in ").append(time).append(" minute(s).");
            } else {
                sb.append("Trapped!");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}

class Tuple {
    int l;
    int r;
    int c;
    int time;

    public Tuple(int l, int r, int c, int time) {
        this.l = l;
        this.r = r;
        this.c = c;
        this.time = time;
    }
}
