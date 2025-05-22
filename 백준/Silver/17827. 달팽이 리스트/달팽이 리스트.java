import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int v;
    static int[] numbers;

    static int lessN(int n) {
        return numbers[n];
    }

    static int excessN(int num, int gap) {
        int rest = (num - 1) % gap;

        if (rest == 0) {
            return numbers[n - 1];
        }

        return numbers[(v - 1) + (rest - 1)];
    }

    static int equalN() {
        return numbers[v - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num >= n) {
                int gap = n - v + 1;

                if (n == v) {
                    sb.append(equalN()).append("\n");
                } else {
                    sb.append(excessN(num, gap)).append("\n");
                }
            } else {
                sb.append(lessN(num)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
