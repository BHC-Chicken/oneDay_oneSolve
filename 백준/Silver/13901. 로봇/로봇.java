import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static int[] dir = new int[4];
    static int[][] map;
    static Pair nowPosition;

    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    static void move(int index) {
        int count = 0;

       while (true) {
           int nx = nowPosition.x + dx[dir[index]];
           int ny = nowPosition.y + dy[dir[index]];

           if (inRange(nx, ny) && map[nx][ny] == 0) {
               map[nowPosition.x][nowPosition.y] = 1;

               nowPosition.x = nx;
               nowPosition.y = ny;

               count = 0;
           } else {
               index++;

               if (index == 4) {
                   index = 0;
               }
               count++;
           }

           if (count == 4) {
               break;
           }
       }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        map = new int[r][c];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int or = Integer.parseInt(st.nextToken());
            int oc = Integer.parseInt(st.nextToken());

            map[or][oc] = 1;
        }

        st = new StringTokenizer(br.readLine());

        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());

        nowPosition = new Pair(sr, sc);

        map[sr][sc] = 1;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            dir[i] = Integer.parseInt(st.nextToken());
        }

        move(0);

        System.out.println(nowPosition.x + " " + nowPosition.y);
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
