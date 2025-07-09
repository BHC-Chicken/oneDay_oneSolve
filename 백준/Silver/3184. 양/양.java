import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static String[][] map;
    static boolean[][] visited;

    static int o;
    static int v;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new String[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = split[j];

                if (map[i][j].equals("o")) {
                    o++;
                } else if (map[i][j].equals("v")) {
                    v++;
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!map[i][j].equals("#") && !visited[i][j]) {
                    int countO = 0;
                    int countV = 0;

                    ArrayDeque<Pair> pairs = new ArrayDeque<>();
                    pairs.add(new Pair(i, j));
                    visited[i][j] = true;

                    if (map[i][j].equals("o")) {
                        countO++;
                    } else if (map[i][j].equals("v")) {
                        countV++;
                    }

                    while (!pairs.isEmpty()) {
                        Pair pair = pairs.poll();
                        int x = pair.x;
                        int y = pair.y;

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (inRange(nx, ny) && !map[nx][ny].equals("#") && !visited[nx][ny]) {
                                if (map[nx][ny].equals("o")) {
                                    countO++;
                                } else if (map[nx][ny].equals("v")) {
                                    countV++;
                                }

                                visited[nx][ny] = true;
                                pairs.add(new Pair(nx, ny));
                            }
                        }
                    }

                    if (countO > countV) {
                        v -= countV;
                    } else {
                        o -= countO;
                    }
                }
            }
        }

        System.out.println(o + " " + v);
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
