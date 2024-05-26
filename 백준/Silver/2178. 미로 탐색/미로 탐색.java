import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int x;
    static int y;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] steps;
    static Queue<Pair> queue;

    static boolean inRange(int cx, int cy) {
        return cx >= 0 && cx < x && cy >= 0 && cy < y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int count = 1;

        arr = new int[x][y];
        steps = new int[x][y];

        visited = new boolean[x][y];
        queue = new LinkedList<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < x; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < y; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int cx = 0;
        int cy = 0;

        queue.add(new Pair(0, 0));
        visited[0][0] = true;
        steps[0][0] = 1;
        boolean loop = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            for (int k = 0; k < 4; k++) {
                cx = pair.x + dx[k];
                cy = pair.y + dy[k];

                if (inRange(cx, cy) && !visited[cx][cy]) {
                    visited[cx][cy] = true;

                    if (arr[cx][cy] == 1) {
                        queue.add(new Pair(cx, cy));
                        count++;
                        steps[cx][cy] = steps[pair.x][pair.y] + 1;
                    }
                }
            }
        }

        System.out.println(steps[x - 1][y - 1]);
    }
}