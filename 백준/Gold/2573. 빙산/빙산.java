import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static Queue<Pair> queue = new LinkedList<>();

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static void search() {
        int size = queue.size();
        int[][] tempMap = new int[n][m];

        for (int i = 0; i < size; i++) {
            Pair p = queue.poll();

            for (int j = 0; j < 4; j++) {
                int nx = p.x + dx[j];
                int ny = p.y + dy[j];

                if (inRange(nx, ny) && map[nx][ny] == 0 && map[p.x][p.y] != 0) {
                    tempMap[p.x][p.y] += 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempMap[i][j] > 0) {
                    map[i][j] -= tempMap[i][j];
                }

                if (map[i][j] > 0) {
                    queue.add(new Pair(i,j));
                } else {
                    map[i][j] = 0;
                }
            }
        }
    }

    static int bfs() {
        boolean[][] visited = new boolean[n][m];
        ArrayList<Pair> copy = new ArrayList<>(queue);
        Queue<Pair> pairQueue = new LinkedList<>();
        int count = 0;

        for (Pair p : copy) {
            if (!visited[p.x][p.y]) {
                pairQueue.add(p);

                while (!pairQueue.isEmpty()) {
                    Pair pair = pairQueue.poll();
                    visited[pair.x][pair.y] = true;

                    for (int j = 0; j < 4; j++) {
                        int nx = pair.x + dx[j];
                        int ny = pair.y + dy[j];

                        if (inRange(nx, ny) && map[nx][ny] != 0 && !visited[nx][ny]) {
                            pairQueue.add(new Pair(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }
                }

                count++;
            }
        }

        return count;
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

                if (num != 0) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        int year = 0;
        int divide = 1;

        while (divide == 1 && !queue.isEmpty()) {
            year++;
            search();
            divide = bfs();
        }

        if (divide > 1) {
            System.out.println(year);
        } else {
            System.out.println(0);
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