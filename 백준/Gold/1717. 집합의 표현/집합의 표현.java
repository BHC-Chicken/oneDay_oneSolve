import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    static int find(int x) {
        if (x == arr[x]) {
            return x;
        }

        return arr[x] = find(arr[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            arr[x] = y;
        }
    }

    static boolean isSameNum(int x, int y) {
        x = find(x);
        y = find(y);

        return x == y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cmd == 0) {
                union(a,b);
            } else if (cmd == 1) {
                if (isSameNum(a,b)) {
                    sb.append("YES");
                } else {
                    sb.append("NO");
                }

                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}

