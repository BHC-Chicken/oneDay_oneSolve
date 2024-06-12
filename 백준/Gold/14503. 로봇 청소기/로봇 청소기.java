import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int r;
    static int c;
    static int d;
    static int[][] map;
    static boolean[][] cleaned;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        cleaned = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        while (true) {
            if (!cleaned[r][c]) {
                cleaned[r][c] = true;
                result++;
            }

            boolean moved = false;
            
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !cleaned[nx][ny] && map[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    moved = true;
                    
                    break;
                }
            }

            if (!moved) {
                int backDir = (d + 2) % 4;
                int backX = r + dx[backDir];
                int backY = c + dy[backDir];

                if (backX >= 0 && backY >= 0 && backX < n && backY < m && map[backX][backY] == 0) {
                    r = backX;
                    c = backY;
                } else {
                    break;
                }
            }
        }

        System.out.println(result);
    }
}