import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int train;
    static int[][] arr;

    static void cmd1(int trainNo, int x) {
        arr[trainNo][x] = 1;
    }

    static void cmd2(int trainNo, int x) {
        arr[trainNo][x] = 0;
    }

    static void cmd3(int trainNo) {
        for (int i = 19; i > 0; i--) {
            arr[trainNo][i] = arr[trainNo][i - 1];
        }

        arr[trainNo][0] = 0;
    }

    static void cmd4(int trainNo) {
        for (int i = 0; i < 19; i++) {
            arr[trainNo][i] = arr[trainNo][i + 1];
        }

        arr[trainNo][19] = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> set = new HashSet<>();
        int result = 0;

        train = Integer.parseInt(st.nextToken());
        int cmds = Integer.parseInt(st.nextToken());

        arr = new int[train][20];

        for (int i = 0; i < cmds; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                int trainNo = Integer.parseInt(st.nextToken()) - 1;
                int seat = Integer.parseInt(st.nextToken()) - 1;

                cmd1(trainNo, seat);
            } else if (cmd == 2) {
                int trainNo = Integer.parseInt(st.nextToken()) - 1;
                int seat = Integer.parseInt(st.nextToken()) - 1;

                cmd2(trainNo, seat);
            } else if (cmd == 3) {
                int trainNo = Integer.parseInt(st.nextToken()) - 1;

                cmd3(trainNo);
            } else {
                int trainNo = Integer.parseInt(st.nextToken()) - 1;

                cmd4(trainNo);
            }
        }

        for (int[] ar : arr) {
            set.add(Arrays.toString(ar));
        }

        System.out.println(set.size());
    }
}
