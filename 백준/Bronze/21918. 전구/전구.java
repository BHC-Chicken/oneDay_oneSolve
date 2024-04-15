import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] light;

    static void cmd1(int x, int status) {

        light[x] = status;
    }

    static void cmd2(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (light[i] == 1) {
                light[i] = 0;
            } else {
                light[i] = 1;
            }
        }
    }

    static void cmd3(int start, int end) {
        for (int i = start; i <= end; i++) {
            light[i] = 0;
        }
    }

    static void cmd4(int start, int end) {
        for (int i = start; i <= end; i++) {
            light[i] = 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        light = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            light[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 1:
                    cmd1(x, y);
                    break;
                case 2:
                    cmd2(x, y);
                    break;
                case 3:
                    cmd3(x, y);
                    break;
                case 4:
                    cmd4(x, y);
            }
        }

        for (int i = 1; i <= n ; i++) {
            sb.append(light[i]).append(" ");
        }

        System.out.println(sb);
    }
}
