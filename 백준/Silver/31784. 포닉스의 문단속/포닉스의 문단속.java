import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static char[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n];
        String word = br.readLine();
        map = word.toCharArray();

        for (int i = 0; i < n; i++) {
            if (map[i] == 'A') {
                continue;
            }
            int move = 'Z' - map[i] + 1;

            if (k >= move) {
                map[i] = 'A';
                k -= move;
            }

            if (k == 0) {
                break;
            }
        }

        if (k > 0) {
            if (k > 26) {
                k %= 26;
            }
            map[n - 1] += k;
        }

        for (int i = 0; i < n; i++) {
            sb.append(map[i]);
        }

        System.out.println(sb);
    }
}