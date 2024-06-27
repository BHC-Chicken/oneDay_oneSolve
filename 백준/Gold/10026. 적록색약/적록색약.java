import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static String[][] map;
    static String[][] weekMap;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static int bfs(String[][] arr) {
        int count = 0;
        visited = new boolean[n][n];
        Queue<Tuple> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    queue.add(new Tuple(i, j, arr[i][j]));
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        Tuple tuple = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = tuple.x + dx[k];
                            int ny = tuple.y + dy[k];

                            if (inRange(nx, ny) && !visited[nx][ny] && tuple.s.equals(arr[nx][ny])) {
                                queue.add(new Tuple(nx, ny, arr[nx][ny]));
                                visited[nx][ny] = true;
                            }
                        }
                    }

                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new String[n][n];
        weekMap = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] word = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = word[j];

                if (word[j].equals("R") || word[j].equals("G")) {
                    weekMap[i][j] = "R";
                } else {
                    weekMap[i][j] = word[j];
                }
            }
        }

        sb.append(bfs(map)).append(" ").append(bfs(weekMap));

        System.out.println(sb);
    }
}

class Tuple {
    int x;
    int y;
    String s;

    public Tuple(int x, int y, String s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }
}