import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m;
    static int n;
    static int k;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static void createMap(int x1, int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                map[i][j] = 1;
                visited[i][j] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        int divide = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            createMap(a, b, c, d);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    Queue<Pair> pairQueue = new ArrayDeque<>();
                    pairQueue.add(new Pair(i, j));
                    int count = 1;
                    divide++;

                    while (!pairQueue.isEmpty()) {
                        Pair pair = pairQueue.poll();

                        for (int l = 0; l < 4; l++) {
                            int nx = pair.x + dx[l];
                            int ny = pair.y + dy[l];

                            if (inRange(nx, ny) && !visited[nx][ny]) {
                                count++;
                                pairQueue.add(new Pair(nx, ny));
                                visited[nx][ny] = true;
                            }
                        }
                    }

                    list.add(count);
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(divide).append("\n");

        for (int i : list) {
            sb.append(i).append(" ");
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
