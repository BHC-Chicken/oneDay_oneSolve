import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w;
    static int h;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w;
    }

    static boolean isAtBoundary(int x, int y) {
        return x == 0 || x == h - 1 || y == 0 || y == w - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < tc; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            String[][] map = new String[h][w];

            Queue<Pair> fire = new LinkedList<>();
            Queue<Pair> exit = new LinkedList<>();

            boolean[][] fireVisited = new boolean[h][w];
            boolean[][] exitVisited = new boolean[h][w];

            Pair startPoint = null;

            for (int i = 0; i < h; i++) {
                String[] road = br.readLine().split("");

                for (int j = 0; j < w; j++) {
                    String word = road[j];
                    map[i][j] = word;

                    if (word.equals("@")) {
                        startPoint = new Pair(i, j);
                        exitVisited[i][j] = true;
                        exit.add(startPoint);
                    }

                    if (word.equals("*")) {
                        fire.add(new Pair(i, j));
                        fireVisited[i][j] = true;
                    }
                }
            }

            boolean escaped = false;
            int timeCount = 0;

            if (startPoint != null && isAtBoundary(startPoint.x, startPoint.y)) {
                sb.append(1).append("\n");
                continue;
            }

            while (!exit.isEmpty() && !escaped) {
                int size = fire.size();
                for (int i = 0; i < size; i++) {
                    Pair nFire = fire.poll();
                    for (int j = 0; j < 4; j++) {
                        int nx = nFire.x + dx[j];
                        int ny = nFire.y + dy[j];
                        if (inRange(nx, ny) && !fireVisited[nx][ny] && (map[nx][ny].equals(".") || map[nx][ny].equals("@"))) {
                            fire.add(new Pair(nx, ny));
                            fireVisited[nx][ny] = true;
                        }
                    }
                }

                size = exit.size();
                for (int i = 0; i < size; i++) {
                    Pair people = exit.poll();
                    for (int j = 0; j < 4; j++) {
                        int nx = people.x + dx[j];
                        int ny = people.y + dy[j];
                        if (inRange(nx, ny) && map[nx][ny].equals(".") && !exitVisited[nx][ny] && !fireVisited[nx][ny]) {
                            if (isAtBoundary(nx, ny)) {
                                escaped = true;
                                break;
                            }
                            exit.add(new Pair(nx, ny));
                            exitVisited[nx][ny] = true;
                        }
                    }
                    if (escaped) {
                        break;
                    }
                }
                timeCount++;
            }

            if (escaped) {
                sb.append(timeCount + 1).append("\n");
            } else {
                sb.append("IMPOSSIBLE").append("\n");
            }
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
