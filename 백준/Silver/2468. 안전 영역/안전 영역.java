import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        SafeAreaSolution SAS = new SafeAreaSolution();
        SAS.init();
        SAS.solve();
    }
}

class SafeAreaSolution {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int max;
    static int[][] map, sArea;
    static boolean[][] visited;

    static int size;

    public void solve() {

        int result = 0;

        for(int depth = 0; depth <= max + 1; depth++) {

            int cnt = 0;
            findArea(depth);
            visited = new boolean[size][size];

            for(int r = 0; r < size; r++) {
                for(int c = 0; c < size; c++) {
                    if(!visited[r][c] && sArea[r][c] == 1) {
                        cnt++;
                        dfs(r, c);
                    }
                }
            }

            result = Math.max(result, cnt);
        }

        System.out.println(result);
    }

    public void dfs(int row, int col) {

        visited[row][col] = true;

        for(int dir = 0; dir < 4; dir++) {

            int nRow = row + dx[dir];
            int nCol = col + dy[dir];

            if(nRow >= 0 && nCol >= 0 && nRow < size && nCol < size && !visited[nRow][nCol] && sArea[nRow][nCol] == 1) {
                dfs(nRow, nCol);
            }
        }
    }

    public void findArea(int depth) {

        sArea = new int[size][size];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(map[i][j] >= depth) {
                    sArea[i][j] = 1;
                }
            }
        }
    }

    public void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        visited = new boolean[size][size];

        for(int r = 0; r < size; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < size; c++) {
                int num = Integer.parseInt(st.nextToken());
                map[r][c] = num;

                max = Math.max(num, max);
            }
        }

    }
}