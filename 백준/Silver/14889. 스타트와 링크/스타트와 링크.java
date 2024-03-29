import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static boolean[] visit;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0);
        System.out.println(min);

    }

    static void combination(int index, int count) {
        if (count == n / 2) {
            diff();
            return;
        }
        for (int i = index; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                combination(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }

    static void diff() {
        int teamA = 0;
        int teamB = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visit[i] && visit[j]) {
                    teamA += map[i][j];
                    teamA += map[j][i];
                } else if (!visit[i] && !visit[j]) {
                    teamB += map[i][j];
                    teamB += map[j][i];
                }
            }
        }

        int val = Math.abs(teamA - teamB);

        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(val, min);
    }

}