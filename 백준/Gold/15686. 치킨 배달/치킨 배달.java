import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int result = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Pair> homes = new ArrayList<>();
    static ArrayList<Pair> chicken = new ArrayList<>();

    static void dfs(int start, int count) {
        if (count == m) {
            int sum = 0;

            for (int i = 0; i < homes.size(); i++) {
                Pair home = homes.get(i);
                int temp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    Pair c = chicken.get(j);

                    if (visited[c.x][c.y]) {
                        int distance = Math.abs(home.x - c.x) + Math.abs(home.y - c.y);
                        temp = Math.min(temp, distance);
                    }
                }

                sum += temp;
            }

            result = Math.min(sum, result);

            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            Pair c = chicken.get(i);

            visited[c.x][c.y] = true;
            dfs(i + 1, count + 1);
            visited[c.x][c.y] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(line[j]);

                if (map[i][j] == 1) {
                    homes.add(new Pair(i, j));
                }
                if (map[i][j] == 2) {
                    chicken.add(new Pair(i, j));
                }
            }
        }

        dfs(0, 0);

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