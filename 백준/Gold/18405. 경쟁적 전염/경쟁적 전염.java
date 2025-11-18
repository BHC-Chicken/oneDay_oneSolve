import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] arr = new int[n][n];
        ArrayList<ArrayList<Pair>> list = new ArrayList<>();

        for (int i = 0; i <= k; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());

                arr[i][j] = num;

                if (num != 0) {
                    list.get(num).add(new Pair(i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int findX = Integer.parseInt(st.nextToken());
        int findY = Integer.parseInt(st.nextToken());


        for (int i = 0; i < s; i++) {
            for (int j = 1; j <= k; j++) {
                ArrayList<Pair> pairList = list.get(j);
                int size = pairList.size();

                for (int m = 0; m < size; m++) {
                    Pair p = pairList.remove(0);

                    for (int l = 0; l < 4; l++) {
                        int nx = p.x + dx[l];
                        int ny = p.y + dy[l];

                        if (inRange(nx, ny) && arr[nx][ny] == 0) {
                            arr[nx][ny] = j;
                            pairList.add(new Pair(nx, ny));
                        }
                    }
                }
            }
        }

        System.out.println(arr[findX - 1][findY - 1]);
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
